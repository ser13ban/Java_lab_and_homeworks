package com.company;

import com.company.commands.*;
import com.company.excepitons.NotValidCommandException;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NotValidCommandException {
        Catalog c = new Catalog();
        //c.add("C:\\Users\\Mihai\\Pictures\\moon_tree_starry_sky_132139_1920x1080.jpg", "picture1");
        //c.add("D:\\Movies\\naruto\\naruto\\[DB]_Naruto_Movie_1_[D367824A].avi","video1");
        //c.add("C:\\Users\\Mihai\\Music\\ACDC-Thunderstruck(OfficialVideo).mp3","melody1");
        Scanner in = new Scanner(System.in);
        Boolean exit = false;
        while(!exit){
            System.out.println("\n\nHello, you can use one of the followint commands (WARRING: all of the parameters of the commands are mandatory)");
            System.out.println("add <param1> <param2> (where param1 is the link to the file and param2 is the nem of the file)");
            System.out.printf("list -- this commnad list the intems in the catalog"); //done
            System.out.println("play <param1> (where param1 is the name of the file) -- it opens the file with the default app");
            System.out.println("save --this command saves the catalog in the catalog.txt file"); //done
            System.out.println("load <param> (where param is the name of the file) -- it loads the catalog from the file in the param1");
            System.out.println("clear -- clears the screen"); //done
            System.out.println("quit -- exit the program"); //done

            System.out.println();

            String command = in.nextLine();
            try{
                checkCommand(command);
            }catch (Exception e){
                System.out.println(e.toString());
            }

            if (command.equals("quit")){
                exit = true;
            }else if (command.startsWith("save")){
                new SaveCommand(c);
            }
            else if (command.startsWith("add")){
                String[] arguemts = command.split(" ");
                new AddCommand(c, arguemts[1], arguemts[2]);
            }
            else if (command.startsWith("list")){
                new ListCommand(c);
            }
            else if (command.startsWith("play")){
                String[] argumets = command.split(" ");
                new PlayCommand(c,argumets[1]);
            }
            else if (command.startsWith("load")){
                String[] argumets =command.split(" ");
                new LoadCommand(c, argumets[1]);
            }
            else if (command.startsWith("report")){
                try {
                    new ReportCommand(c);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if(command.startsWith("clear")){
                try
                {
                    final String os = System.getProperty("os.name");

                    if (os.contains("Windows"))
                    {
                        Runtime.getRuntime().exec("cls");
                    }
                    else
                    {
                        Runtime.getRuntime().exec("clear");
                    }
                }
                catch (final Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void checkCommand(String command) throws NotValidCommandException {
        String[] commandArguemts = command.split(" ");
        if (!commandArguemts[0].equals("add") &&
            !commandArguemts[0].equals("play") &&
            !commandArguemts[0].equals("load") &&
            !commandArguemts[0].equals("save") &&
            !commandArguemts[0].equals("report") &&
            !commandArguemts[0].equals("quit") &&
            !commandArguemts[0].equals("list") &&
            !commandArguemts[0].equals("clear")
        ){
            throw new NotValidCommandException("We don't have available the command: " + commandArguemts[0] );
        }
        else if (commandArguemts[0].equals("add") || commandArguemts[0].equals("load")){
            //for the functions that take a path we ckeck if the path is valid
            File file = new File(commandArguemts[1]);
            if (!file.isDirectory())
                file = file.getParentFile();
            if (!file.exists()){
                throw new NotValidCommandException("The path that you provided points to a non existing  file");
            }
            if (commandArguemts[1].isEmpty()){
                throw new NotValidCommandException("I need a file for this command");
            }
        }
    }
}
