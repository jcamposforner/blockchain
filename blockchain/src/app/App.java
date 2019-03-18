package app;

import java.util.ArrayList;

public class App {
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    
    public static void main(String[] args) throws Exception {
		blockchain.add(new Block("Hi im the first block", "0"));		
		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash)); 
		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
        
        Wallet wallet = new Wallet();
        System.out.println(wallet.publicKey);
    }
}