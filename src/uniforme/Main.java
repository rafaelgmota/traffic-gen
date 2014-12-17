/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uniforme;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Main 
{

    public static void main(String[] args) 
    {
    	
    	String caminho="";
    	int dimX=0;
    	int dimY=0;
    	int n_pck=0;
    	int Flits=0;
    	int flitWidth=0;
    	ArrayList<Double> rates = new ArrayList();
    	
    	if(args.length == 6) 
    	{
    		
    		dimX=Integer.parseInt(args[0]); //X dimension
    		dimY=Integer.parseInt(args[1]); //Y dimension
    		n_pck=Integer.parseInt(args[2]); //100 packets per core
    		Flits=Integer.parseInt(args[3]); //#flits
    		flitWidth=Integer.parseInt(args[4]);
    		String[] inputRates = args[5].split(",");
    		
    		for(String rate : inputRates)
    			rates.add(Double.parseDouble(rate));
    	} 
    	else 
    	{    		
    		dimX=2; //X dimension
    		dimY=2; //Y dimension
    		n_pck=10; //100 packets per core
    		Flits=100; //#flits
    		rates.add(20.0);
    		rates.add(80.0);
    		flitWidth=16;
    	}
    	
        int desX=2,desY=2; //for hot spot
        String str ="random"; //uniform -> random ; else -> hot spot
        //double rates[] = {80.0};
       
        caminho = variaveis.chooser();
        
        
       
        escreve_arquivo teste = new escreve_arquivo(dimX,dimY,flitWidth,1,flitWidth,n_pck,Flits,50.0,desX,desY,"msg");
        
        
        teste.gera_destinos(str,dimX,dimY,n_pck,desX,desY);
        //teste.gera_destino_petri();
        //teste.gera_destino_omnet();
        

        for(int i=0; i < rates.size();i++)
        {
             teste.writeTraffic(str,caminho+"\\F"+(rates.get(i).intValue()),rates.get(i));
             teste.printNofPcks(caminho+"\\F"+(rates.get(i).intValue())+"\\");
        }
        

        

        System.out.println("Done, check selected directory");
        JOptionPane.showMessageDialog(null, "Done, check selected directory", "Traffic Generator  ", JOptionPane.INFORMATION_MESSAGE);

    }

}