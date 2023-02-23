package fr.rodez3il.a2022.mrmatt;


public class Rocher extends ObjetPlateau {
	
	private EtatRocher etat;
		
	public void visiterPlateauCalculEtatSuivant(Niveau plateau, int x, int y) {
		plateau.etatSuivantVisiteur(this, x, y);
	}

	@Override
	public char afficher() {
		return (etat ==EtatRocher.FIXE) ? '*' : '!';
	}

	public Rocher() {
		etat = EtatRocher.FIXE;
	}

	public EtatRocher getEtat() {
		return etat;
	}

	public void setEtat(EtatRocher etat) {
		this.etat = etat;
	}
	@Override
	public boolean estMarchable() {
		return false;
	}
	
	@Override
	public boolean estPoussable() {
		return true;
	}

	@Override
	public boolean estGlissant() {
		return true;
	}
	
}
