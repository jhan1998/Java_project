import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Scanner;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JPanel{
	public static JFrame frame = new JFrame("Plague Inc.");
	public static JPanel topPanel = new JPanel();
	public static JLayeredPane layeredPane = new JLayeredPane();
	static public JButton btn = new JButton("START");
	static public JLabel lb = new JLabel("Plague .Inc");
	static public JLabel lbimage = new JLabel();
	static public JButton easy = new JButton(/*"EASY"*/);
	static public JButton medium = new JButton(/*"MEDIUM"*/);
	static public JButton hard = new JButton(/*"HARD"*/);
	static public int r = 0 ,g = 0 ,b = 0;
	static public double[][]   coeff = { {1.0,1.0,0.75,1.25,0.75,0.5,1.5},{1.0,1.0,1.5,1.0,1.25,1.25,0.5}
										,{1.0,1.0,0.75,0.5,0.75,1.25,1.5},{1.25,1.0,0.5,0.75,0.75,0.75,1.5},{1.5,1.5,2.0,1.5,1.75,1.75,1.0}	} ;
	public static void main(String... args) {
		frame.setSize(1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		imple mblistener = new imple();
		btn.addActionListener(mblistener);
		btn.setLocation(500, 660); 
		btn.setSize(200, 50);
        //btn.setBackground(Color.RED);
        //btn.setContentAreaFilled(false);
        //btn.setOpaque(false);
		
		//lb.setLocation(520,140);
		//lb.setSize(200, 200);
		//lb.setFont(new Font("Dialog", Font.PLAIN, 36));				
		//ImageIcon img = new ImageIcon("./src/101485283_1515133622000456_8554929947112636416_n.jpg");
		//img.setImage(img.getImage().getScaledInstance(100,100,100));

        topPanel.setLayout(null);
        topPanel.setBounds(0, 0, 1200, 800);
		
		//lbimage.setIcon(img);
		//lbimage.setLocation(550,110);
		//lbimage.setSize(100,100);
		ImageIcon bg = new ImageIcon("./src/https___hk.hypebeast.com_files_2020_03_plague-inc-covid-19-donation-news-1.jpg");
		bg.setImage(bg.getImage().getScaledInstance(1200,800,800));
		lbimage.setIcon(bg);
		lbimage.setLocation(0,0);
		lbimage.setSize(1200,800);
		
        layeredPane =new JLayeredPane();
        EmptyBorder eb = new EmptyBorder(new Insets(0, 0, 100, 100));
        layeredPane.setBorder(eb);
        layeredPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        layeredPane.setBounds(0,0,1200,800);
        layeredPane.setLayout(null);
        layeredPane.add(btn, JLayeredPane.MODAL_LAYER);
        //layeredPane.add(lb, JLayeredPane.MODAL_LAYER);
        layeredPane.add(lbimage, JLayeredPane.DEFAULT_LAYER);
		
		//frame.add(btn);
		//frame.add(lb);
		//frame.add(lbimage);
        topPanel.add(layeredPane);        
        frame.getContentPane().add(topPanel);
		frame.getContentPane().setBackground(Color.WHITE);
				
		frame.setLayout(null);    
		frame.setVisible(true);

	    

	}
}
/*	    
//主程式--------------------------------------------------------------------------------------

		int 	 roundCounter=0,point=0,choose1,choose2,identity;
		String[] country={"China","America","Japan","Canada","Korea","Taiwan","Ethiopia"};    			 
		int[][]	 population= {{140006,32973,12230,3759,5164,2360,10986},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}; 
		int[][]  temp = new int[3][7];                                                                                    
		int[]    worldPopulation= {0,0,0},accu=new int[2];   
		int[][]  folw=new int[7][7],flowpp=new int[2][7],exchange=new int[3][7];
		double   v_air=0,v_con=0,v_env=0,v_resi=0,v_var=0,v_fat=0,v_danger=0,v_inf[]=new double [7];
		int[] 	 cost={0,0,0,0,0,0},v_level={0,0,0,0,0,0}   ;
		double	 vacc_ability,vacc_efficiency,vacc_progress=0,x;
		
				
//困難度--------------------------------------------------------------------------------------		
		Virus_parameter version = new Virus_parameter();
		double[][] coeff = version.getParameter();
		
//Game===========================================================================================
		Scanner read = new Scanner(System.in);
//病毒選擇--------------------------------------------------------------------------------------
		identity=0;
		while (identity==0) {
			 System.out.println( "Choose your virus !"  );
		     System.out.println( "1 = COVID-19");
		     System.out.println( "2 = Japanese encephalitis");
		     System.out.println( "3 = Zika virus");
		     System.out.println( "4 = MERS");
		     System.out.println( "5 = H1N1");
		     System.out.println( "6 = Spanish flu");
		     System.out.println( "7 = Lyme disease");
		     identity = read.nextInt() ;
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
		}
		for (int k = 0; k < 7; k++) {
			System.out.println(country[k]);
			System.out.printf("  Health people:    %8d%n",population[0][k]);
			System.out.printf("  Infection people: %8d%n",population[1][k]);
			System.out.printf("  Dead people:      %8d%n",population[2][k]);				
		}
		                                                                                                 
//病毒感染模型------------------------------------------------------------
		while(true){
		    roundCounter=roundCounter+1;                       
			System.out.printf("Round   : %5d%n",roundCounter);				
	loop1 :	while ((point>= IntStream.of(cost).min().orElse(Integer.MAX_VALUE))) {
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
				}
				System.out.println("Press 99 to exit");
		        choose1 = read.nextInt();
		        if ((choose1<=6)&&(choose1>=1)&&(point<cost[(choose1-1)])) {
		        	System.out.println("skipping");
		        	continue;
		        
		        }
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
		            if ((v_fat>=0)&&(v_fat<0.04)) {
		              point=point-cost[4];
		              v_level[4]=v_level[4]+1;
					  v_fat=0+0.0040*v_level[4];
		            }
		            else if (v_fat>=0.040) {
		              v_fat=0.04;
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
				case 99:
		         break loop1 ;  
				default :
				 System.out.println( "Try again");
				 break; 
		        }
			    
			    
			    VirusPanel virusPanel =new VirusPanel(point, v_air, v_con, v_env, v_fat, v_resi, v_var);
                frame.setVisible(true);
                
				System.out.printf("point      =  %3d%n",point);
				System.out.printf("Air        =  %5.3f%n",v_air);
				System.out.printf("Contact    =  %5.3f%n",v_con);				
				System.out.printf("Environment=  %5.3f%n",v_env);				
				System.out.printf("Resistance =  %5.3f%n",v_resi);				
				System.out.printf("v_fat      =  %5.3f%n",v_fat);
				System.out.printf("v_varation =  %5.3f%n",v_var);				   
			}//END while
				
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
			 		v_fat=0.004*v_level[4];
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
				    if(x<=0.05) { 
				        System.out.println("The Secretary-General of the World Health Organization, Tan Desai, "
				        		+ "asked all countries in the world not to worry about infectious diseases, "
				        		+ "and encouraged countries to travel to China and conduct economic and trade exchanges.");
				        System.out.println("Enter your decision : ");
						System.out.println("1 = Allow local people to return home");
						System.out.println("2 = Resist all tourists from China");
						System.out.println("3 = Insulted Tan Desai as an idiot");
				        choose2 = read.nextInt();      
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
					        population[0][k]=(population[0][k])-temp[1][k];            //各國總健康人數=總健康人數+回合健康人數
					        population[1][k]=(population[1][k])+temp[1][k]-temp[2][k]; //各國總感染人數=總感染人數+回合感染人數-回合死亡人數		
					        population[2][k]=(population[2][k])+temp[2][k] ;           //各國總死亡人數=總死亡人數+回合死亡人數
							for (int i = 0; i < 3; i++) {							   //人數不為負值
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
						     System.out.printf("Vaccine : %6.2f%n",vacc_progress*100);
						    //輸出玩家的輸贏--------------------------------------------------------------------------------		
						         if ((worldPopulation[0]<=0) && (worldPopulation[1]<=0)) {             
						            System.out.println( "You win !");
						    		break;
						         }
						    	 else if(vacc_progress>=1){
						    		System.out.println( "Vaccine has been made.");
						    		System.out.println( "You lose !");
						    		break;
						         }
			    
		}//END while loop1
	 read.close();                                                                                                    
	}  //STOP                                                                                                  
}       */