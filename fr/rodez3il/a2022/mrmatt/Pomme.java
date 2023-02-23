package fr.rodez3il.a2022.mrmatt;

public class Pomme  extends ObjetPlateau {

	@Override
	public char afficher() {
		// TODO Auto-generated method stub
		return '+';
	}

	@Override
	public boolean estMarchable() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void visiterPlateauCalculEtatSuivant(Niveau plateau, int x, int y) {
		plateau.etatSuivantVisiteur(this, x, y);
	}

}
