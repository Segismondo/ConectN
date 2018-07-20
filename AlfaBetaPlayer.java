//java.conectaN
package conectan;

import java.util.ArrayList;

/**
 *
 * @author José María Serrano
 * @version 1.3 Departamento de Informática. Universidad de Jáen
 *
 * Inteligencia Artificial. 2º Curso. Grado en Ingeniería Informática
 *
 * Clase AlfaBetaPlayer para representar al jugador CPU que usa la poda Alfa
 * Beta
 *
 * Esta clase es la que tenemos que implementar y completar
 *
 */
public class AlfaBetaPlayer extends Player {





    void buscarcasillas(int [][]tabla, ArrayList defender, ArrayList pdefender, int x,int y){
        //x=nfilas, y=ncolumnas mira de izquierda a derecha
        for(int i=0;i<x-3;i++){//el menos 3, es para hacerlo mas eficiente
            for(int j=0;j<y;j++){
                //primera fase
                if(tabla[i][j]==-1 && tabla[i+1][j]==-1){
                    if(tabla[i+2][j]==0){
                        pdefender.add(8);
                        defender.add(j);
                    }
                    if(tabla[i+2][j]==-1 && tabla[i+3][j]==0 && j==y-1){
                        pdefender.add(16);
                        defender.add(j);
                    }else{
                        if(tabla[i+2][j]==-1 && tabla[i+3][j]==0 && tabla[i+3][j+1]!=0){
                            pdefender.add(16);
                            defender.add(j);
                        }
                    }
                }
                if(tabla[i][j]==-1 && tabla[i+1][j]==0 && tabla[i+2][j]==-1){
                    pdefender.add(16);
                    defender.add(j);
                }
            }
        }
        for(int i=x-1;i>2;i--){
            for(int j=y-1;j>=0;j--){
                //primera fase parte 2
                if(tabla[i][j]==-1 && tabla[i-1][j]==-1){
                    if(tabla[i-2][j]==0){
                        pdefender.add(8);
                        defender.add(j);
                    }
                    if(tabla[i-2][j]==-1 && tabla[i-3][j]==0 && j==y-1){
                        pdefender.add(16);
                        defender.add(j);
                    }else{
                        if(tabla[i-2][j]==-1 && tabla[i-3][j]==0 && tabla[i-3][j-1]!=0){
                            pdefender.add(16);
                            defender.add(j);
                        }
                    }
                }
                if(tabla[i][j]==-1 && tabla[i-1][j]==0 && tabla[i-2][j]==-1){
                    if(j==y-1){
                        pdefender.add(16);
                        defender.add(j);
                    }else{
                        if(tabla[i-1][j-1]!=0){
                            pdefender.add(16);
                            defender.add(j);
                        }
                    }
                }
            }
        }
//fin primera fase
                //segunda fase 
        for(int i=0;i<x;i++){
            for(int j=y-1; j>2;j--){
                if(tabla[i][j]==0){
                    break;
                }
                if(tabla[i][j]==-1 && tabla[i][j-1]==-1){
                    if(tabla[i][j-2]==0){
                        pdefender.add(4);
                        defender.add(j);
                       
                    }
                    if(tabla[i][j-2]==-1 && tabla[i][j-3]==0){
                        pdefender.add(16);
                        defender.add(j);
                        
                    }
                }
            }
        }
    }



    //casillas para ganar
    void buscarcasillasParaGanar(int [][]tabla, ArrayList atacar, ArrayList patacar,int x,int y){
        //x=nfilas, y=ncolumnas mira de izquierda a derecha
        for(int i=0;i<x-3;i++){//el menos 3, es para hacerlo mas eficiente
            for(int j=0;j<y;j++){
                //primera fase
                if(tabla[i][j]==1 && tabla[i+1][j]==1){
                    if(tabla[i+2][j]==0){
                        patacar.add(2);
                        atacar.add(j);
                    }
                    if(tabla[i+2][j]==1 && tabla[i+3][j]==0 && j==y-1){
                        patacar.add(50);
                        atacar.add(j);
                    }else{
                        if(tabla[i+2][j]==1 && tabla[i+3][j]==0 && tabla[i+3][j+1]!=0){
                            patacar.add(50);
                            atacar.add(j);
                        }
                    }
                }
                if(tabla[i][j]==1 && tabla[i+1][j]==0 && tabla[i+2][j]==1){
                    if(j==y-1){
                        patacar.add(50);
                        atacar.add(j);
                    }else{
                        if(tabla[i+1][j+1]!=0){
                            patacar.add(50);
                            atacar.add(j);
                        }
                    }
                }
            }
        }
        for(int i=x-1;i>2;i--){
            for(int j=y-1;j>=0;j--){
                //primera fase parte 2
                if(tabla[i][j]==1 && tabla[i-1][j]==1){
                    if(tabla[i-2][j]==0){
                        patacar.add(2);
                        atacar.add(j);
                    }
                    if(tabla[i-2][j]==1 && tabla[i-3][j]==0){
                        patacar.add(4);
                        atacar.add(j);
                    }
                }
                if(tabla[i][j]==1 && tabla[i-1][j]==0 && tabla[i-2][j]==1){
                    patacar.add(50);
                    atacar.add(j);
                }
            }
        }
//fin primera fase
                //segunda fase
        for(int i=0;i<x;i++){
            for(int j=y-1; j>2;j--){
                if(tabla[i][j]==0){
                    break;
                }
                if(tabla[i][j]==1 && tabla[i][j-1]==1){
                    if(tabla[i][j-2]==0){
                        patacar.add(1);
                        atacar.add(j-2);
                        break;
                    }
                    if(tabla[i][j-2]==1 && tabla[i][j-3]==0){
                        patacar.add(50);
                        atacar.add(j-3);
                        break;                    }
                }
            }
        }
                //fin segunda base, tenemos las posiciones de abajo a arriba
                
        //tercera fase
        //parte 1
        /*for(int i=0;i<x;i++){
            for(int j=y-1; j>2;j--){
                if(tabla[i][j]==0){
                    break;
                }
                if(tabla[i][j]==1 && tabla[i+1][j-1]==1){
                    if(tabla[i+2][j-2]==0 && tabla[i+2][j-1]!=0){
                       patacar.add(1);
                        atacar.add(j-2);
                    }
                    if(tabla[i+2][j-2]==1 && tabla[i+3][j-3]==0 && tabla[i+3][j-2]!=0){
                        patacar.add(50);
                        atacar.add(j-3);
                    }
                }
            }
        }
        //parte 2
        for(int i=x-1;i>2;i++){
            for(int j=y-1; j>2;j--){
                if(tabla[i][j]==0){
                    break;
                }
                if(tabla[i][j]==1 && tabla[i-1][j-1]==1){
                    if(tabla[i-2][j-2]==0 && tabla[i-2][j-1]!=0){
                        patacar.add(1);
                        atacar.add(j-2);
                    }
                    if(tabla[i-2][j-2]==1 && tabla[i-3][j-3]==0 && tabla[i-3][j-2]!=0){
                        patacar.add(50);
                        atacar.add(j-3);
                    }
                }
            }
        } */          
    }
    
    
        
           
     //min y max el valor max llama al min
    int valorMax(Grid tablero, int alfa, int beta, int conecta, ArrayList at, ArrayList pat,ArrayList def, ArrayList pdef) {
        int col=-2;
        if(at.isEmpty())
            return col;
        if(def.isEmpty()){
            return col;
        }else {
            for (int i = 0; i < at.size(); i++) {
                if(beta < (int) pdef.get(i)){
                    beta= (int) pdef.get(i);
                    col = (int) def.get(i);
                }
            }
            //la funciÃ³n max busca la mejor jugada para la computadora y la peor la el rival.
            alfa = Math.max(alfa, valorMin(tablero, alfa, beta, at, pat,conecta));//le asigna a alfa el mayor de los valores entre alfa y elMinimo valor calculado por min.

            if (alfa >= beta){
                for (int i=0;i<at.size();i++){
                    if((int)pat.get(i)==alfa)
                        return (int)at.get(i);
                }
            }
            if (beta==0){
                return -2;
            }
        }
        return col;
    }
    
    int valorMin(Grid tablero, int alfa, int beta, ArrayList at, ArrayList pat,int conecta) {
        if(at.isEmpty()){
            return -2;
        }else {
            for (int i = 0; i < at.size(); i++) {
                if(beta < (int) pat.get(i)){
                    alfa= (int) pat.get(i);
                }
                if(alfa < (int) pat.get(i)){
                    alfa= (int) pat.get(i);
                }
            }
            if (alfa >= beta){
                return alfa;
            }  
        }
        return beta;
    }
   
        
        
    //heuristica
    public void heuristica(Grid tablero, ArrayList def,ArrayList pdef, ArrayList  at, ArrayList  pat,int conecta) {
        ArrayList nuevo=new ArrayList();
        ArrayList nuevo1=new ArrayList();
        ArrayList nuevo2=new ArrayList();
        ArrayList nuevo3=new ArrayList();
        for(int i=0;i<def.size();i++){
            nuevo.add((int) pdef.get(i)*8);
        }
        pdef=nuevo;
        for(int i=0; i<def.size(); i++){
            for(int j=0;j<at.size(); j++){
                if((int) def.get(i)==(int) at.get(j) && (int)def.get(i)== (int)at.get(j)){
                    nuevo1.add((int) at.get(j)*2);
                }
            }
        }
        pat=nuevo1;
        for(int i=0; i<def.size()-1; i++){
            for(int j=0;j<def.size()-1; j++){
                if((int)def.get(i) == (int) def.get(j) && (int) def.get(i) == (int) def.get(j)){
                    nuevo2.add((int) def.get(j)*8);
                }
            }
        }
        pdef=nuevo2;
        for(int i=0; i<at.size()-1; i++){
            for(int j=0;j<at.size()-1; j++){
                if( (int)at.get(i) == (int)at.get(j) && (int)at.get(i) == (int)at.get(j)){
                    nuevo3.add((int)at.get(j)*2);
                }
            }
        }
        pat=nuevo3;
    }
        
    
    /**
     *
     * @param tablero Representación del tablero de juego
     * @param conecta Número de fichas consecutivas para ganar
     * @return Jugador ganador (si lo hay)
     */
    @Override
    public int jugada(Grid tablero, int conecta) {
    
        int [][]tabla=tablero.toArray();
        ArrayList defender = new ArrayList();
        ArrayList pdefender = new ArrayList();
        ArrayList patacar = new ArrayList();
        ArrayList atacar = new ArrayList();
        

        buscarcasillas(tabla,defender,pdefender,tablero.getFilas(),tablero.getColumnas());
        buscarcasillasParaGanar(tabla,atacar, patacar, tablero.getFilas(),tablero.getColumnas());
        heuristica(tablero, defender, pdefender, atacar, patacar, conecta);
        
        int valor = valorMax(tablero, 0, 0, conecta, atacar,  patacar, defender, pdefender);
        
        if(valor!=-2){
            return tablero.checkWin(tablero.setButton(valor, ConectaN.JUGADOR2), valor, conecta);
        }
        int ccolumna = getRandomColumn(tablero);
        return tablero.checkWin(tablero.setButton(ccolumna, ConectaN.JUGADOR2), ccolumna, conecta);
        //return tablero.checkWin(tablero.setButton(columna, ConectaN.JUGADOR2), columna, conecta);

    } // jugada
    
    
} // AlfaBetaPlayer