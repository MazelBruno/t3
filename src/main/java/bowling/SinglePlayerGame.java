package bowling;

import java.util.ArrayList;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */


      

public class SinglePlayerGame {
        private int[][] tableaulance;
        //= new int[12][2];        
        private int[] etatdulance;
        //= new int [10];
        private int score;
        private boolean premierlance;
        private int tour;
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            this.tableaulance= new int[12][2];
            for( int i = 0 ; i < 12 ; i++){
                for (int j = 0 ; j < 2 ; j++){
                    tableaulance[i][j]=0;
                }
            }
            this.etatdulance = new int[12];
            for (int i= 0 ; i < 12 ; i++ ){
                this.etatdulance[i]=0;
            }
            
            
            this.tour=0;
            this.score=0;
            this.premierlance=true;

	}
        
        public void toursuivant(){
            this.premierlance=true;
            if (this.tour < 11)
                this.tour++;
            
        }

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int tombe) {

            
            if (this.premierlance==true){
                this.tableaulance[tour][0]=tombe;                
            }else{
                this.tableaulance[tour][1]=tombe;
            }
                        
            if  (this.tableaulance[tour][0]==10 || this.premierlance==false){
                if(tombe==10 && this.premierlance==true){
                    this.etatdulance[tour]=2;
                }else{
                    if ((this.tableaulance[tour][0]+this.tableaulance[tour][1])==10){
                        this.etatdulance[tour]=1;
                    }else{
                        this.etatdulance[tour]=0;
                    }
                }
            System.out.println(this.calcul());
            System.out.println(this.tour);
                this.toursuivant();
                return;
            }
            if (this.premierlance==true){
                    this.premierlance=false;
            }
            System.out.println(this.calcul());
            System.out.println(this.tour);
            
        }
                    
	
        
        public void gettableau(){
            for (int i = 0 ; i < 12 ; i++){
                for (int j = 0 ; j < 2 ; j++){
                    System.out.print(this.tableaulance[i][j]+" ");
                    if (j==1){
                        System.out.println("voici l'état du tour "+i+" "+this.etatdulance[i]);
                    }
                }
                System.out.println("");
            }
        }
        

        
        

        public int calcul(){
            this.score = 0;
            
            for(int i = 0 ; i <10 ;i++){
            
                for (int j = 0 ; j < 2 ; j++){
                    this.score = this.score + this.tableaulance[i][j];
                }
                if (this.etatdulance[i]==1 && i+1 <= 12 ){
                    this.score = this.score + this.tableaulance[i+1][0];   
                }else{
                    if (this.etatdulance[i]==2){
                        if (this.etatdulance[i+1]==1 || this.etatdulance[i+1]==0){
                            this.score = this.score + this.tableaulance[i+1][0] + this.tableaulance[i+1][1];
                        }else{
                            if(this.etatdulance[i+1]==2){
                                this.score = this.score + this.tableaulance[i+1][0]+ this.tableaulance[i+2][0];  
                            }
                        }  
                    }   
                }  
            }
            
            return(this.score);
        }

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
		return this.calcul();
	}
}
