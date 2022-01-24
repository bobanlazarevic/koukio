package com.lazarevic.boban.koukio.commands;

public enum CommandEnum {

  ENTER("ENTER"),
  SERVED("SERVED"),
  ;

  private String commandName;

  private CommandEnum(String commandName) {
    this.commandName = commandName;
  }

  public String getCommandName() {
    return commandName;
  }

}
