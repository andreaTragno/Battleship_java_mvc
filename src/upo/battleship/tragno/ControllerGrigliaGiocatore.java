package upo.battleship.tragno;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ControllerGrigliaGiocatore {
	
	VistaGrigliaGiocatore vistaPlayer;
	BattleshipModel model;
	BattleshipController battleshipController;
	int i = 0;
	
	public ControllerGrigliaGiocatore(VistaGrigliaGiocatore vista, BattleshipModel model, BattleshipController battleshipController) {
		this.model = model;
		this.vistaPlayer = vista;
		this.battleshipController = battleshipController;
		
	}
	
	public MouseListener assegnaGestoreCelle(int x, int y) {
		MouseListener gestoreCelle;
		ArrayList<Nave> navi;
		gestoreCelle = new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(model.getFase() == 1) {
					
					ArrayList<Nave> navi =  model.getGiocatore().getNaviDaPosizionare();
					
					for(int j = 0; j < navi.size(); j ++) {
						System.out.println("NAVI :" + navi.get(j).getNome());
					}
					
					Nave nave = navi.get(i);
					
					try {
						System.out.println("PRIMA DEL IF GIOCATORE");
						
						if(!model.getGiocatore().getNaviDaPosizionare().isEmpty()) {
							
							System.out.println("Dopo if GIOCATORE");
								
									
									System.out.println("NAVE BEFORE:" + navi.get(i).getNome());
									
									boolean valuta = model.getGiocatore().posizionaNave(nave, x, y);
									
								//	System.out.println("NAVE AFTER POSIZIONA CGC (NAVI.GET):" + navi.get(i).getNome());
									System.out.println("NAVE AFTER POSIZIONA CGC (NAVE):" + nave.getNome());
									//System.out.println("CELLA GIOCATORE");
									
									if(valuta == true) {
										
										System.out.println("POSIZIONO " + nave.getNome() + " " + nave.getLunghezza());
										//x y invertite
										vistaPlayer.posizionaNave(nave, y, x);
											
										System.out.println("HO POSIZIONATO");
									}//fine if
									
									else if(valuta == false) {
										navi.add(nave);
										System.out.println("Posizione non valida");
									}//fine else
							
						}//fine while
					}catch (Exception exc) {
						System.out.println("ERRORE POSIZIONAMENTO NAVE " + exc.getMessage());
					}
					finally {
						if(model.getGiocatore().getNaviDaPosizionare().isEmpty()) {
							model.faseBattaglia();
							System.out.println("Inizio fase" + model.getFase());
						}
					}
				}	
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		return gestoreCelle;
	}
	
}
