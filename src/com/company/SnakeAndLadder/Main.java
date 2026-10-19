package com.company.SnakeAndLadder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController gc = null;
        while(sc.hasNextLine()){
            System.out.println();
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            if(parts[0].equals("create_game")){
                gc = new GameController(null);
                gc.setBoard(new Board(Integer.parseInt(parts[1])));
                System.out.println("Board created with size = "+parts[1]);
                System.out.println("Ready to play..");

            }else if(parts[0].equals("addPlayer")){
                if(isGameOn(gc) ){
                    if(gc.isStarted()){
                        System.out.println("Cannot add player. Game already started..");
                    }else{
                        Player curr = new Player(gc.getPlayersSize(), 0, parts[1]);
                        gc.addPlayer(curr);
                        System.out.println("Player added. Id: "+ curr.getId()+ ", Name: "+ curr.getName());

                    }

                }

            }else if(parts[0].equals("startGame")){
                if(isGameOn(gc)){
                    System.out.println("Game started");
                    gc.startGame();
                    System.out.println("Game ended");
                }

            }else if(parts[0].equals("displayLeaderBoard")){
                if(isGameOn(gc)){
                    gc.showLeaderBoard();
                }
            }
            else if(parts[0].equals("showPlayers")){
                if(isGameOn(gc)){
                    gc.showPlayers();
                }
            }
            else if(parts[0].equals("addSnake")){
                if(isGameOn(gc)){
                    System.out.println(gc.addBoardEntity(BoardEntityType.SNAKE, Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                }
            }
            else if(parts[0].equals("addLadder")){
                if(isGameOn(gc)){
                    System.out.println(gc.addBoardEntity(BoardEntityType.LADDER, Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                }
            }
            else{
                System.out.println("Invalid command!");
            }
        }
    }

    static boolean isGameOn(GameController gc){
        if(gc==null){
            System.out.println("Game not found..");
            System.out.println("Please create a game first.");
            return false;
        }
        return true;
    }
}
