package com.lazarevic.boban.koukio.priorities;

import com.lazarevic.boban.koukio.commands.CommandEnum;
import com.lazarevic.boban.koukio.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {

  private static Priorities instance = null;

  private PriorityQueue<Student> queue;

  private Priorities() {
    queue = new PriorityQueue<>();
  }

  public static Priorities getInstance() {
    if (instance == null)
      instance = new Priorities();

    return instance;
  }

  public List<Student> getStudents(List<String> events) {
    if (null == events || events.isEmpty()) {
      new ArrayList<>(0);
    }

    queue.clear();

    for (String event : events) {
      String[] commands = event.split(" ");

      if (commands[0].equals(CommandEnum.ENTER.getCommandName())) {
        queue.add(new Student(Integer.valueOf(commands[3]), commands[1], Double.valueOf(commands[2])));
      } else if (!queue.isEmpty() && commands[0].equals(CommandEnum.SERVED.getCommandName())) {
        queue.remove();
      }
    }

    List<Student> students = new ArrayList<>(queue.size());
    while(!queue.isEmpty()) {
      students.add(queue.remove());
    }

    return students;
  }

}
