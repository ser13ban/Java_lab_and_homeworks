package com.company;

import com.company.commands.*;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NotValidCommand {
        Catalog c = new Catalog();
        c.add("C:\\Users\\Mihai\\Pictures\\moon_tree_starry_sky_132139_1920x1080.jpg", "picture1");
        c.add("D:\\Movies\\naruto\\naruto\\[DB]_Naruto_Movie_1_[D367824A].avi","video1");
        c.add("C:\\Users\\Mihai\\Music\\ACDC-Thunderstruck(OfficialVideo).mp3","melody1");
        Scanner in = new Scanner(System.in);
        Boolean exit = false;
        while(!exit){
            System.out.println("\n\nHello, you can use one of the followint commands (WARRING: all of the parameters of the commands are mandatory)");
            System.out.println("add <param1> <param2> (where param1 is the link to the file and param2 is the nem of the file)");
            System.out.printf("list -- this commnad list the intems in the catalog"); //done
            System.out.println("play <param1> (where param1 is the name of the file) -- it opens the file with the default app");
            System.out.println("save --this command saves the catalog in the catalog.txt file"); //done
            System.out.println("load <param> (where param is the name of the file) -- it loads the catalog from the file in the param1");
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
                SaveCommand s = new SaveCommand();
                s.Save(c);
            }
            else if (command.startsWith("add")){
                AddCommand a = new AddCommand();
                String[] arguemts = command.split(" ");
                a.add(c, arguemts[1], arguemts[2]);
            }
            else if (command.startsWith("list")){
                ListCommand l = new ListCommand();
                l.list(c);
            }
            else if (command.startsWith("play")){
                PlayCommand p = new PlayCommand();
                String[] argumets = command.split(" ");
                p.play(c,argumets[1]);
            }
            else if (command.startsWith("load")){
                LoadCommand l = new LoadCommand();
                String[] argumets =command.split(" ");
                l.load(c, argumets[1]);
            }
            else if (command.startsWith("report")){
                ReportCommand r = new ReportCommand();
                try {
                    r.report(c);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void checkCommand(String command) throws NotValidCommand{
        String[] commandArguemts = command.split(" ");
        if (!commandArguemts[0].equals("add") &&
            !commandArguemts[0].equals("play") &&
            !commandArguemts[0].equals("load") &&
            !commandArguemts[0].equals("save") &&
            !commandArguemts[0].equals("report") &&
            !commandArguemts[0].equals("quit")
        ){
            throw new NotValidCommand("We don't have available the command: " + commandArguemts[0] );
        }
        else if (commandArguemts[0].equals("add") || commandArguemts[0].equals("load")){
            //for the fumctioins that take a path we ckeck if the path is valid
            File file = new File(commandArguemts[1]);
            if (!file.isDirectory())
                file = file.getParentFile();
            if (!file.exists()){
                throw new NotValidCommand("The path that you provided points to a non existing  file");
            }
        }
    }
}
