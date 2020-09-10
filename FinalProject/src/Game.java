import java.util.Scanner;
import java.util.logging.Level;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.util.Timer;
import java.util.TimerTask;


public class Game extends Main implements ActionListener {
//簡單版 地獄級 把病毒能力另寫一個Class	
//可為兩個主螢幕  各國人口情況 和 病毒能力可另存在
//對話框也另存在
//	
	private int	roundCounter=0,point=0,choose1,choose2,identity;
	private String[] country={"China","America","Japan","Canada","Korea","Taiwan","Ethiopia"};    			 
	private int[][]	 population= {{140006,32973,12230,3759,5164,2360,10986},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}; 
	private int[][]  temp = new int[3][7];                                                                                    
	private int[]    worldPopulation= {0,0,0},accu=new int[2];   
	private int[][]  folw=new int[7][7],flowpp=new int[2][7],exchange=new int[3][7];
	private double   v_air=0,v_con=0,v_env=0,v_resi=0,v_var=0,v_fat=0,v_danger=0,v_inf[]=new double [7];
	private int[] 	 cost={0,0,0,0,0,0},v_level={0,0,0,0,0,0}   ;
	private double	 vacc_ability,vacc_efficiency,vacc_progress=0,x;
	private JButton[] btn,lbtn;
	private JLabel lbb;
	private boolean randomEventFlag = false;
	private Timer timer;
	private JLabel lbimage1 = new JLabel();

			
//Game===========================================================================================	
	
	public Game() {
		//lbb = new JLabel("Choose your virus !");
		//lbb.setLocation(250,140);
		//lbb.setSize(800, 200);
		//lbb.setFont(new Font("Dialog", Font.HANGING_BASELINE, 80));
        //layeredPane.add(lbb, JLayeredPane.MODAL_LAYER);
		//frame.add(lbb);
		ImageIcon ez = new ImageIcon("./src/種類.jpg");
		ez.setImage(ez.getImage().getScaledInstance(1200,800,900));
		lbimage1.setIcon(ez);
		lbimage1.setLocation(0,-30);
		lbimage1.setSize(1200,800);
        layeredPane.add(lbimage1, JLayeredPane.MODAL_LAYER);
        
		btn = new JButton[7];
		//String[] virus = {"COVID-19", "Japanese encephalitis", "Zika virus", "MERS", "H1N1", "Spanish flu", "Lyme disease"};
		for(int i=0;i<7;i++) {
			btn[i] = new JButton(/*virus[i]*/);
			btn[i].addActionListener(this);
	        //frame.add(btn[i]);
			layeredPane.add(btn[i], JLayeredPane.POPUP_LAYER);	
			btn[i].setContentAreaFilled(false);
			btn[i].setOpaque(false);
			btn[i].setBounds(295*i+20, 90, 275, 330);
			if (i>3) {
				btn[i].setBounds(295*i+-1015, 430, 275, 328);
			}
						
		}
		////////////////////////
//病毒選擇--------------------------------------------------------------------------------------
		identity=0;
		System.out.println( "Choose your virus !"  );
	     System.out.println( "1 = COVID-19");
	     System.out.println( "2 = Japanese encephalitis");
	     System.out.println( "3 = Zika virus");
	     System.out.println( "4 = MERS");
	     System.out.println( "5 = H1N1");
	     System.out.println( "6 = Spanish flu");
	     System.out.println( "7 = Lyme disease");   
		/////////////////////////
	}
		
	public void gameStart() {
		timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(!randomEventFlag) {
					round();
					America america = new America(population[0][1] + population[1][1] + population[2][1],population[2][1]);
					Canada canada = new Canada(population[0][3] + population[1][3] + population[2][3],population[2][3]);
					Ethiopia ethiopia = new Ethiopia(population[0][6] + population[1][6] + population[2][6],population[2][6]);
					China china = new China(population[0][0] + population[1][0] + population[2][0],population[2][0]);
					Korea korea = new Korea(population[0][4] + population[1][4] + population[2][4],population[2][4]);
					Japan japan = new Japan(population[0][2] + population[1][2] + population[2][2],population[2][2]);
					Taiwan taiwan = new Taiwan(population[0][5] + population[1][5] + population[2][5],population[2][5]);
				}
			}
		};
		timer.schedule(timerTask, 1000, 250);
		switch (identity) {
		case 1: {
	           System.out.println( "You chose COVID-19 from China !");
	           point=7;
	           population[0][0]=population[0][0]-1;
	           population[1][0]=population[1][0]+1;
		}break;
		case 2: {
	           System.out.println( "You chose Japanese encephalitis from Japan !");
	           point=3;
	           population[0][2]=population[0][2]-1;
	           population[1][2]=population[1][2]+1;				
		}break;
		case 3: {
	           System.out.println( "You chose Zika virus from Ethiopia !");
	           point=6;
	           population[0][6]=population[0][6]-1;
	           population[1][6]=population[1][6]+1;		
		}break;
		case 4: {
	           System.out.println( "You chose MERS from Korea !");
	           point=5;
	           population[0][4]=population[0][4]-1;
	           population[1][4]=population[1][4]+1;			
		}break;
		case 5: {
	           System.out.println( "You chose H1N1 from Taiwan !");
	           point=3;
	           population[0][5]=population[0][5]-1;
	           population[1][5]=population[1][5]+1 ;		
		}break;
		case 6: {
	           System.out.println( "You chose Spanish flu from America !");
	           point=5;
	           population[0][1]=population[0][1]-1	;
	           population[1][1]=population[1][1]+1	;
		}break;
		case 7: {
	           System.out.println( "You chose Lyme disease from Canada !");
	           point=4;
	           population[0][3]=population[0][3]-1;
	           population[1][3]=population[1][3]+1;	
		}break;
		default:
	           System.out.println( "Try again");
			   identity=0;
		}
		for (int k = 0; k < 7; k++) {
			System.out.println(country[k]);
			System.out.printf("  Health people:    %8d%n",population[0][k]);
			System.out.printf("  Infection people: %8d%n",population[1][k]);
			System.out.printf("  Dead people:      %8d%n",population[2][k]);				
		}
		
		// create round button
		lbtn = new JButton[6];
		String[] str = {"空氣傳播", "接觸感染", "環境因子", "抗藥性", "致死率", "變異率"};
		for(int i=0;i<6;i++) {
			lbtn[i] = new JButton(str[i]);
			lbtn[i].addActionListener(this);
			
			layeredPane.add(lbtn[i], JLayeredPane.POPUP_LAYER);	
			//btn[i].setContentAreaFilled(false);
			//btn[i].setOpaque(false);
			
			//frame.add(lbtn[i]);
			int x = frame.getHeight()/6;
			if (i<=2) {
				lbtn[i].setBounds(180+(225*i), 530, 175, 50);
			}
			else {
				lbtn[i].setBounds(180+(225*(i-3)),630, 175, 50);
			}
				
		}
		showButton();
	}
	
	public void hideVirusButton() {
		for(int i=0;i<btn.length;i++) {
			btn[i].setVisible(false);
			btn[i].setEnabled(false);
		}
		//lbb.setVisible(false);
		JLabel lbimage2 = new JLabel();
		ImageIcon map = new ImageIcon("./src/mapp.jpg");
		map.setImage(map.getImage().getScaledInstance(1200,800,900));
		lbimage2.setIcon(map);
		lbimage2.setLocation(0,-30);
		lbimage2.setSize(1200,800);
        layeredPane.remove(lbimage1);
        layeredPane.add(lbimage2, JLayeredPane.MODAL_LAYER);
	}
	
	public void showButton() {
		for(int i=0;i<lbtn.length;i++) {
			lbtn[i].setVisible(true);
			lbtn[i].setEnabled(true);
		}
	}
	
	
	public void round() {
		roundCounter=roundCounter+1;                       
		System.out.printf("Round   : %5d%n",roundCounter);				

			System.out.printf("point      =  %3d%n",point);
			System.out.printf("Air        =  %5.3f%n",v_air);
			System.out.printf("Contact    =  %5.3f%n",v_con);				
			System.out.printf("Environment=  %5.3f%n",v_env);				
			System.out.printf("Resistance =  %5.3f%n",v_resi);				
			System.out.printf("v_fat      =  %5.3f%n",v_fat);
			System.out.printf("v_varation =  %5.3f%n",v_var);				   
		    VirusPanel virusPanel =new VirusPanel(point, v_air, v_con, v_env, v_fat, v_resi, v_var);
	        frame.setVisible(true);
			
//變異率---------------------------------------------------------------------------------	 
		      x = Math.random();  
			  if (x<=v_var && (v_level[0]<10)) {                          
		         v_level[0]=v_level[0]+1;
		 		v_air=0.01*v_level[0];
		      }
		      x = Math.random(); 
		      if (x<=v_var && (v_level[1]<10)) {
		         v_level[1]=v_level[1]+1;
		 		v_con=0.01*v_level[1];		
		      }
			  x = Math.random(); 
		      if (x<=v_var&& (v_level[2]<10)) {
		         v_level[2]=v_level[2]+1;
		 		v_env=0.01*v_level[2];
		      }
			  x = Math.random(); 
		      if (x<=v_var&& (v_level[3]<10)) {
		         v_level[3]=v_level[3]+1;
		 		v_resi=0.01*v_level[3];
		      }
			  x = Math.random(); 
		      if (x<=v_var && (v_level[4]<10)) {
		         v_level[4]=v_level[4]+1;
		 		v_fat=0.008*v_level[4];
		      }		
				System.out.printf("point      =  %3d%n",point);
				System.out.printf("Air        =  %5.3f%n",v_air);
				System.out.printf("Contact    =  %5.3f%n",v_con);				
				System.out.printf("Environment=  %5.3f%n",v_env);				
				System.out.printf("Resistance =  %5.3f%n",v_resi);				
				System.out.printf("v_fat      =  %5.3f%n",v_fat);
				System.out.printf("v_varation =  %5.3f%n",v_var);				

//隨機事件-------------------------------------------------------------------------------------
			  
				x = Math.random(); 
			    if(x<=0.005) {
			    	randomEventFlag = true;
			    	randomEvent();
			    }
		    
//流動人口-------------------------------------------------------------------------------------
			    for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 7; j++) {
				        if(((double)(population[1][i])/((population[0][i])+(population[1][i]))>=0.5)||((double)(population[1][j])/((population[0][j])+(population[1][j]))>=0.5)) {
				              flowpp[1][i]=0;    
				              flowpp[1][j]=0;
							  if(((i==1 && j==3)||(i==0 &&j==4 )||(i==2 && j==4 ))||((j==1 && i==3 )||(j==0 && i==4)||(j==2 && i==4) ))  //3個鄰國情況
								folw[j][i]=(int) ((((population[0][i])+(population[1][i]))+((population[0][j])+(population[1][j])))*0.1);	 //鄰國活著人口的0.1%
							  else
								folw[j][i]=(int) ((((population[0][i])+(population[1][i]))+((population[0][j])+(population[1][j])))*0.01);    //非鄰國活著人口的0.01%					 
				              if(folw[j][i]>=((population[0][i])+(population[1][i])))    //出國數不大於總人口
				                 folw[j][i]=(population[0][i])+(population[1][i]);
							  else if(folw[j][i]>=((population[0][j])+(population[1][j]))) 
								 folw[j][i]=(population[0][j])+(population[1][j]);
				              folw[i][j]=Math.min(folw[j][i],folw[i][j]);  				//取較小的  
				              for (int j2 = 0; j2 <= folw[i][j]; j2++) {
								 x = Math.random();
				                 if(x<=((double)((population[1][i]))/((population[0][i])+(population[1][i])))) {  
				                    flowpp[1][i]=flowpp[1][i]+1;
				                 }
								 x = Math.random();
				                 if(x<=((double)((population[1][j]))/((population[0][j])+(population[1][j])))) {
				                    flowpp[1][j]=flowpp[1][j]+1;
				                 }
							  }   
				                 					              
				              flowpp[0][i]=folw[j][i]-flowpp[1][i]; 
				              flowpp[0][j]=folw[i][j]-flowpp[1][j];
				              if (flowpp[0][i]<=0) {
				            	  flowpp[0][i]=0;
							}
				              if (flowpp[0][j]<=0) {
				            	  flowpp[0][j]=0;
							}
				              for (int l = 0; l < 2; l++) {
				            	 
								 population[l][i]=population[l][i]+flowpp[l][j]-flowpp[l][i];
				                 population[l][j]=population[l][j]+flowpp[l][i]-flowpp[l][j];
							  }
				                
					    }
					}
				}
	
//人口情形輸出-------------------------------------------------------------------------------------
				worldPopulation[0]= 0 ;
			    worldPopulation[1]= 0 ;
			    worldPopulation[2]= 0 ;
			    //每回合死亡人數
			    for (int k = 0; k < 7; k++) {
					temp[2][k]=0; //歸零                   
			        if (population[1][k]>0) {    //不可為0
			           for (int j2 = 1; j2 <= population[1][k]; j2++) {  //感染的一個一個檢查會不會死
			              x = Math.random();
			              if (x<=v_fat) {        
			                 temp[2][k]=temp[2][k]+1;
			              }
					}				        	
			        }		        
				    //每回合感染人數
			        temp[1][k]=0; //歸零
			        exchange[0][k]=(int)(population[1][k])*100;   //藍+橘
			        exchange[1][k]=0;  //藍
			        exchange[2][k]=0;  //橘
			        if(exchange[0][k]>0) {                      
			           if(exchange[0][k]>=(population[0][k]+population[1][k])) {    
			              exchange[1][k]=population[0][k];
			           }
			           else{
			        	   for (int k2 = 1; k2 <=exchange[0][k]; k2++) {
							x = Math.random();
			                 if(x<=((double)(population[1][k])/(population[0][k]+population[1][k]))) {
			                    exchange[2][k]=exchange[2][k]+1; //本身就染病
			                 }
						   }
			           }				             
			           if(exchange[1][k]<=population[0][k]) { //本身健康=藍
			              exchange[1][k]=exchange[0][k]-exchange[2][k];//(橘+藍)-藍
			           }
			           if(exchange[1][k]>population[0][k]) {	//不超過
			              exchange[1][k]=population[0][k];
			           }
			        }
				        for (int i = 0; i < 7; i++) {
							v_inf[i]=v_air*coeff[0][i]+v_con*coeff[1][i]+v_env*coeff[2][i]+v_resi*coeff[3][i];
						}
				        for (int i = 1; i <= exchange[1][k]; i++) {		//本身健康接觸後染病機率
							  x = Math.random();
				              if (x<=v_inf[k]) {
				                 temp[1][k]=temp[1][k]+1;
				              }
						}
//每回合總染病、死亡人口--------------------------------------------------------------------------------
						accu[0]=accu[0]+temp[1][k]; 
				        accu[1]=accu[1]+temp[2][k];
						while(accu[0]>=15000) {          //每累積感染15000人增加一點
							accu[0]=accu[0]-15000;
							point=point+1;
						}
						while(accu[1]>=12000) {          //每累積死亡12000人增加一點
							accu[1]=accu[1]-12000;
							point=point+1;
						}
				        population[0][k]=(population[0][k])- Math.abs(temp[1][k]); //各國總健康人數=總健康人數+回合健康人數
				        population[1][k]=(population[1][k])+temp[1][k]-Math.abs(temp[2][k]); //各國總感染人數=總感染人數+回合感染人數-回合死亡人數		
				        population[2][k]=(population[2][k])+temp[2][k] ;           //各國總死亡人數=總死亡人數+回合死亡人數
						for (int i = 0; i < 3; i++) {								//人數不為負值
							if(population[i][k]<0) {
							   population[i][k]=0;
							}
						}
//人口Class==================================================================
PopulationDiagram populationDiagram = new PopulationDiagram(k,country[k],population[0][k],population[1][k],population[2][k],temp[1][k],temp[2][k],v_inf[k]);
frame.setVisible(true);

//人口Class==================================================================						
						System.out.println(country[k]); 
						System.out.printf("  Health people         : %8d%n",population[0][k]);
						System.out.printf("  Infection people      : %8d (+%6d)%n",population[1][k],temp[1][k]);
						System.out.printf("  Dead people           : %8d (+%6d)%n",population[2][k],temp[2][k]);
						System.out.printf("  Infection coefficient : %8.3f%n",v_inf[k]);
				        worldPopulation[0]=worldPopulation[0]+population[0][k];    //總健康人口
				        worldPopulation[1]=worldPopulation[1]+population[1][k];    //總感染人口
				        worldPopulation[2]=worldPopulation[2]+population[2][k];    //總死亡人口
			    }//END 人口	
						System.out.printf("  Total health people      : %8d%n", worldPopulation[0]);
						System.out.printf("  Total Infection people   : %8d%n", worldPopulation[1]);
						System.out.printf("  Total Dead people        : %8d%n", worldPopulation[2]);
//解藥開發--------------------------------------------------------------------------------------- 	
					     if ((double)(((double)(worldPopulation[1])+(double)(worldPopulation[2]))/(double)((worldPopulation[0])+(double)(worldPopulation[1])+(double)(worldPopulation[2])))>=0.3) {
					         vacc_ability=0;
					         v_danger=(v_air+v_con+v_env+v_resi)*v_fat/0.04/0.012;
					         for (int j = 0; j < 5; j++) {
								vacc_ability = vacc_ability+((population[0][j]+population[1][j]/3)*coeff[4][j]);    //開發能力
							}
					            vacc_efficiency = vacc_ability*v_danger/(((1+v_var)*((worldPopulation[0]+worldPopulation[1]+worldPopulation[2])))+0.0001);  //避免分母為0，+0.0001  
					            vacc_progress = vacc_progress+vacc_efficiency/100; ;                        
					         }

					     if (vacc_progress>0.98) {
							vacc_progress=1.00;
						}
					     System.out.printf("Vaccine : %6.2f%n",vacc_progress*100);
					    
					     VaccPanel vacc =new VaccPanel(vacc_progress);


//輸出玩家的輸贏--------------------------------------------------------------------------------		
					         if ((worldPopulation[0]<=0) && (worldPopulation[1]<=0)) {             
					            System.out.println( "You win !");
					    		win();
					         }
					    	 else if(vacc_progress>=1){
					    		System.out.println( "Vaccine has been made.");
					    		System.out.println( "You lose !");
					    		lose();
					         }
		
	}
	
	public synchronized void levelUp() {
		if((point>= IntStream.of(cost).min().orElse(Integer.MAX_VALUE))) {
			System.out.printf("point= %5d%n",point);
	        if ((v_level[0]>=0)&&(v_level[0]<3))            
	            cost[0]=1;
	         else if ((v_level[0]>=3)&&(v_level[0]<7))     
	            cost[0]=3;
	         else if ((v_level[0]>=7)&&(v_level[0]<10))  
	            cost[0]=5;
	         else if (v_level[0]>=10)  
	            cost[0]=999;
	         
	         if ((v_level[1]>=0)&&(v_level[1]<3))  
	            cost[1]=1;
	         else if ((v_level[1]>=3)&&(v_level[1]<7))  
	            cost[1]=3;
	         else if ((v_level[1]>=7)&&(v_level[1]<10))  
	            cost[1]=5;
	         else if (v_level[1]>=10)  
	            cost[1]=999;
	         
	         if ((v_level[2]>=0)&&(v_level[2]<3))  
	            cost[2]=1;
	         else if ((v_level[2]>=3)&&(v_level[2]<7))  
	            cost[2]=3;
	         else if ((v_level[2]>=7)&&(v_level[2]<10))  
	            cost[2]=5;
	         else if (v_level[2]>=10)  
	            cost[2]=999;
	         
	         if ((v_level[3]>=0)&&(v_level[3]<3))  
	            cost[3]=1;
	         else if ((v_level[3]>=3)&&(v_level[3]<7))  
	            cost[3]=3;
	         else if ((v_level[3]>=7)&&(v_level[3]<10))  
	            cost[3]=5;
	         else if (v_level[3]>=10)  
	            cost[3]=999;
	         
	         if ((v_level[4]>=0)&&(v_level[4]<3))  
	            cost[4]=1;
	         else if ((v_level[4]>=3)&&(v_level[4]<7))  
	            cost[4]=3;
	         else if ((v_level[4]>=7)&&(v_level[4]<10))  
	            cost[4]=5;
	         else if (v_level[4]>=10)  
	            cost[4]=999;
	         
	         if ((v_level[5]>=0)&&(v_level[5]<10))  
	            cost[5]=3;
	         else if (v_level[5]>=10)  
	            cost[5]=999;
	             
	 		System.out.println("Enter 1~6 to level up ! (1=air 2=con 3=env 4=anti 5=v_fat 6=v_var)");
			for (int i = 0; i < 6; i++) {
				System.out.printf("%1d cost= %3d    level= %2d%n",i+1 ,cost[i],v_level[i]);	
			    CostPanel costPanel =new CostPanel(i+1 ,cost[i],v_level[i]);
			}
			System.out.println("Press 99 to exit");
	        
//CostPanel==========================================	

			
//CostPanel==========================================					
			
	        if ((choose1<=6)&&(choose1>=1)&&(point<cost[(choose1-1)])) return;
		    switch (choose1) {
	        case 1:
		        if ((v_air>=0)&&(v_air<0.1)) {          
	                point=point-cost[0];          
	                v_level[0]=v_level[0]+1;                 
					v_air=0+0.010*v_level[0];
		        }
	            else if (v_air>=0.1) {                   
	                v_air=0.1;
	                v_level[0]=10;
					System.out.println("Max Level");
	            }
				 break; 
		    case 2:
	            if ((v_con>=0)&&(v_con<0.1)) {
	              point=point-cost[1];
	              v_level[1]=v_level[1]+1;
				  v_con=0+0.010*v_level[1];
	            }
	            else if (v_con>=0.1) {
	              v_con=0.1;
	              v_level[1]=10;
	              System.out.println("Max Level");
	            }
				 break; 
			case 3:
	            if ((v_env>=0)&&(v_env<0.1)) {
	              point=point-cost[2];
	              v_level[2]=v_level[2]+1;
				  v_env=0+0.010*v_level[2];
	            }
	            else if (v_env>=0.1) {
	              v_env=0.1;
	              v_level[2]=10;
	              System.out.println("Max Level");
	            }
				 break; 
			case 4:
	            if ((v_resi>=0)&&(v_resi<0.1)) {
	              point=point-cost[3];
	              v_level[3]=v_level[3]+1;
				  v_resi=0+0.010*v_level[3];
	            }
	            else if (v_resi>=0.1) {
	              v_resi=0.1;
	              v_level[3]=10;
	              System.out.println("Max Level");
	            }
				 break; 
			case 5:
	            if ((v_fat>=0)&&(v_fat<0.08)) {
	              point=point-cost[4];
	              v_level[4]=v_level[4]+1;
				  v_fat=0+0.0080*v_level[4];
	            }
	            else if (v_fat>=0.080) {
	              v_fat=0.08;
	              v_level[4]=10;
	              System.out.println("Max Level");
	            }
				 break; 
			case 6:
	            if ((v_var>=0)&&(v_var<0.1)) {              
	              point=point-cost[5];
	              v_level[5]=v_level[5]+1;
				  v_var=0+0.010*v_level[5];
	            }
	            else if (v_var>=0.1) {
	              v_var=0.1;
	              v_level[5]=10;
	              System.out.println("Max Level");
	           }
				 break; 
			
			default :
			 break; 
	        }
			System.out.printf("point      =  %3d%n",point);
			System.out.printf("Air        =  %5.3f%n",v_air);
			System.out.printf("Contact    =  %5.3f%n",v_con);				
			System.out.printf("Environment=  %5.3f%n",v_env);				
			System.out.printf("Resistance =  %5.3f%n",v_resi);				
			System.out.printf("v_fat      =  %5.3f%n",v_fat);
			System.out.printf("v_varation =  %5.3f%n",v_var);				   
		}//END while(if)
	    VirusPanel virusPanel =new VirusPanel(point, v_air, v_con, v_env, v_fat, v_resi, v_var);
        frame.setVisible(true);
	}
	
	public void randomEvent() {
		String eventMessage = "WHO秘書長譚德塞發言請世界各國不用擔心傳染疾病，鼓勵各國踴躍到中國旅遊及進行經貿來往。";
		System.out.println("WHO秘書長譚德塞發言請世界各國不用擔心傳染疾病，鼓勵各國踴躍到中國旅遊及進行經貿來往。");
        System.out.println("Enter your decision : ");
		System.out.println("1 = Allow local people to return home");
		System.out.println("2 = Resist all tourists from China");
		System.out.println("3 = Insulted Tan Desai as an idiot");
		///////////////////////////////
        //choose2 = read.nextInt();
		int mType=JOptionPane.QUESTION_MESSAGE;
	    int oType=JOptionPane.YES_NO_CANCEL_OPTION;
		String[] options={"聽從建議保持交通開放，並讓當地國人返國","抵制WHO拒絕所有從中國來的遊客(包括當地國人)","開國際記者會辱罵譚德塞是白癡"};
	    int opt=JOptionPane.showOptionDialog(frame, eventMessage,
	      "Random Event",oType,mType,null,options,"接受");
	    if (opt==JOptionPane.YES_OPTION) {
	        choose2 = 1;
	        randomEventFlag = false;
	    }
	    if (opt==JOptionPane.NO_OPTION) {
	        choose2 = 2;
	        randomEventFlag = false;
	    }
	    if (opt==JOptionPane.CANCEL_OPTION) {
	        choose2 = 3;
	        randomEventFlag = false;
	    }
	    
	    ////////////////////////////////////////
        switch (choose2){
              case 1:
                 System.out.println("Contact increase by 0.001");
                 v_con=v_con+0.001;
              case 2:
                 System.out.println("Contact decrease by 0.001");
                 v_con=v_con-0.001;
                 if(v_con<=0) {
                    v_con=0;
                 }
              case 3:
                 System.out.println("Not thing happened .");
              default:
				 System.out.println("Not thing happened .");
    	}
		if(v_con>0.1){	
		v_con=0.1;
		}
		System.out.printf("point      =  %3d%n",point);
		System.out.printf("Air        =  %5.3f%n",v_air);
		System.out.printf("Contact    =  %5.3f%n",v_con);				
		System.out.printf("Environment=  %5.3f%n",v_env);				
		System.out.printf("Resistance =  %5.3f%n",v_resi);				
		System.out.printf("v_fat      =  %5.3f%n",v_fat);
		System.out.printf("v_varation =  %5.3f%n",v_var);
	    VirusPanel virusPanel =new VirusPanel(point, v_air, v_con, v_env, v_fat, v_resi, v_var);
        frame.setVisible(true);
	}
	
	public void win() {
		timer.cancel();
		/////
		//this.add(rect);
		/////
	    int oType=JOptionPane.YES_NO_CANCEL_OPTION;
		String[] options={"Play again","Exit"};
	    int opt=JOptionPane.showOptionDialog(frame, "You win!", "",oType,-1,null,options, "");
	    if (opt==JOptionPane.YES_OPTION) {
	    	frame.dispose();
	    }
	    if (opt==JOptionPane.NO_OPTION) {
	    	frame.dispose();
	    	System.exit(0);
	    }
	}
	
	public void lose() {
		timer.cancel();
		/////
		//this.add(rect);
		/////
	    int oType=JOptionPane.YES_NO_CANCEL_OPTION;
		String[] options={"Play again","Exit"};
	    int opt=JOptionPane.showOptionDialog(frame, "You lose!", "",oType,-1,null,options, "");
	    if (opt==JOptionPane.YES_OPTION) {
	    	frame.dispose();

	    }
	    if (opt==JOptionPane.NO_OPTION) {
	    	frame.dispose();
	    	System.exit(0);
	    }
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btn[0]) {
			identity = 1;
			hideVirusButton();
			gameStart();
		}
		else if(e.getSource()==btn[1]) {
			identity = 2;
			hideVirusButton();
			gameStart();

		}
		else if(e.getSource()==btn[2]) {
			identity = 3;
			hideVirusButton();
			gameStart();
		}
		else if(e.getSource()==btn[3]) {
			identity = 4;
			hideVirusButton();
			gameStart();
		}
		else if(e.getSource()==btn[4]) {
			identity = 5;
			hideVirusButton();
			gameStart();
		}
		else if(e.getSource()==btn[5]) {
			identity = 6;
			hideVirusButton();
			gameStart();
		}
		else if(e.getSource()==btn[6]) {
			identity = 7;
			hideVirusButton();
			gameStart();
		}
		// round
		else if(e.getSource()==lbtn[0]) {
			choose1 = 1;
			levelUp();
		}
		else if(e.getSource()==lbtn[1]) {
			choose1 = 2;
			levelUp();
		}
		else if(e.getSource()==lbtn[2]) {
			choose1 = 3;
			levelUp();
		}
		else if(e.getSource()==lbtn[3]) {
			choose1 = 4;
			levelUp();
		}
		else if(e.getSource()==lbtn[4]) {
			choose1 = 5;
			levelUp();
		}
		else if(e.getSource()==lbtn[5]) {
			choose1 = 6;
			levelUp();
		}
		
	}	
	
}       