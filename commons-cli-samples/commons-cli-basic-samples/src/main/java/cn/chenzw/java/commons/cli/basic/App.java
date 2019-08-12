package cn.chenzw.java.commons.cli.basic;

import org.apache.commons.cli.*;

public class App {

    public static void main(String[] args) throws ParseException {
        args = new String[]{"-h"};

        Options options = new Options();

        Option help = Option.builder("h").longOpt("help").hasArg(false).required(false).desc("帮助").build();
        options.addOption(help);

        CommandLine commandLine = null;
        try {
            commandLine = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }


        if (commandLine.hasOption("h") || commandLine.hasOption("help")) {
            System.out.println("这是帮助");
            System.exit(0);
        }


        System.out.println(commandLine);

    }
}
