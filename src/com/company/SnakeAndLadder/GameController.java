package com.company.SnakeAndLadder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GameController {

    private Board board;
    private Queue<Player> players;
    public Queue<Player> leaderBoard;
    private Dice dice;
    private boolean started;
    private boolean ended;

    GameController(Board board){
        this.board = board;
        this.players = new LinkedList<>();
        this.dice = new Dice(6);
        this.leaderBoard = new LinkedList<>();
        this.started = false;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public void setDice(Dice dice){
        this.dice = dice;
    }

    public void addPlayer(Player player){
        if(this.ended){
            System.out.println("Game already started. Please create a new game");
            return;
        }
        this.players.add(player);
    }

    private void resetBoard(){
        this.ended = false;
        this.started = false;
        this.players = new LinkedList<>(this.leaderBoard);
        this.leaderBoard = new LinkedList<>();
        Iterator<Player> it = this.players.iterator();
        while(it.hasNext()){
            it.next().setCurrPos(0);
        }
    }

    public void startGame(){

        if(this.ended){
            System.out.println();
            System.out.println("Creating a new game");
            resetBoard();
        }

        this.started = true;

        while(!this.ended ){
            play();
        }


    }

    public void addBoardEntity(String entity, int start, int end){
        System.out.println();
        if(this.board==null){
            System.out.println("Board not yet created");
            return;
        }
        if(this.board.getSize()<start || this.board.getSize()<end || start<1 || end<1){
            System.out.println("Invalid placement position. Add a new position");
            return;
        }

        if(this.board.addEntity(entity, start, end)){
            System.out.println("Placed a"+entity+" at position: "+start+ " , tail: "+end);
        }else{
            System.out.println("There is already an obstacle/helper at position:"+start);
        }

    }


    private void play(){
        System.out.println();

        if(this.ended){
            System.out.println("Game already over..");
            System.out.println("Please create a new game...");
            return;
        }

        if(players.size() == 1){
            this.leaderBoard.add(players.poll());
            this.ended = true;
            System.out.println("Game over ...");
            System.out.println("showing leaderboard --->");
            showLeaderBoard();
            return;
        }

        Player curr = this.players.poll();
        System.out.println("Player: "+ curr.getId()+ " ,Name: "+curr.getName() + " rolled the dice");
        System.out.println("Current position: "+ curr.getCurrPos());
        int dice_roll = dice.roll();
        System.out.println("Dice value: "+ dice_roll);
        int nextPos = board.findNextPosition(curr.getCurrPos() ,dice_roll);
        curr.setCurrPos(nextPos);
        System.out.println("New position: "+ nextPos);

        if(board.isEnd(nextPos)){
            System.out.println("Player: "+ curr.getId()+ " ,Name: "+curr.getName() + " reached destination.");
            leaderBoard.add(curr);
        }else{

            this.players.add(curr);
        }

    }


    public boolean isStarted(){
        return this.started;
    }

    public void showLeaderBoard(){
        System.out.println();
        if(this.leaderBoard.isEmpty()){
            System.out.println("No one won till now..");
        }else{
            Iterator<Player> it = this.leaderBoard.iterator();
            int position = 1;
            while (it.hasNext()){
                Player curr = it.next();
                System.out.println("Position "+ (position++)+": Id: "+ curr.getId()+ " , Name:"+ curr.getName()+ " ");
            }
        }
    }

    public void showPlayers(){
        Iterator<Player> it = this.players.iterator();
        while (it.hasNext()){
            Player curr = it.next();
            System.out.println("Id: "+ curr.getId()+ " created for player: "+ curr.getName()+ ".");
        }
    }

    public int getPlayersSize(){
        return this.players.size();
    }
}
