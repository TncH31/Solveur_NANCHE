package fr.rodez3il.a2022.mrmatt.solveur.structures;

/**
 * Implémentation d'une liste chaînée générique.
 * 
 * @param <T> type des éléments stockés dans la liste
 * @author Nanche Thibaud
 */
public class ListeChainee<T> implements Liste<T> {

  /**
   * Classe interne représentant un maillon de la liste chaînée.
   */
  private class Maillon {
    private T donnee;
    private Maillon suivant;

    /**
     * @author Nanche Thibaud
     * Constructeur d'un maillon.
     * 
     * @param donnee  l'élément stocké dans le maillon
     * @param suivant le maillon suivant dans la liste chaînée
     */
    public Maillon(T donnee, Maillon suivant) {
      this.donnee = donnee;
      this.suivant = suivant;
    }
  }

  private Maillon tete;
  private int taille;

  /**
   * @author Nanche Thibaud
   * Constructeur de la liste chaînée.
   */
  public ListeChainee() {
    this.tete = null;
    this.taille = 0;
  }

  /**
   * @author Nanche Thibaud
   *  Ajoute un élément à la fin de la liste.
   * 
   * @param element l'élément à ajouter
   */
  public void ajouter(T element) {
    if (this.tete == null) {
      this.tete = new Maillon(element, null);
    } else {
      Maillon courant = this.tete;
      while (courant.suivant != null) {
        courant = courant.suivant;
      }
      courant.suivant = new Maillon(element, null);
    }
    this.taille++;
  }

  /**
   * @author Nanche Thibaud
   * Vérifie si la liste est vide.
   * 
   * @return true si la liste est vide, false sinon
   */
  public boolean estVide() {
    return this.taille == 0;
  }

  /**
   * Retourne la taille de la liste.
   * 
   * @return la taille de la liste
   */
  public int taille() {
    return this.taille;
  }

  /**
   * @author Nanche Thibaud
   * Enlève l'élément à l'indice spécifié dans la liste.
   * 
   * @param i l'indice de l'élément à enlever
   * @return l'élément enlevé de la liste
   * @throws IndexOutOfBoundsException si l'indice est invalide
   */
  public T enlever(int i) {
    if (i < 0 || i >= this.taille) {
      throw new IndexOutOfBoundsException("L'index spécifié est invalide.");
    }
    Maillon courant = this.tete;
    if (i == 0) {
      this.tete = this.tete.suivant;
    } else {
      for (int j = 0; j < i - 1; j++) {
        courant = courant.suivant;
      }
      courant.suivant = courant.suivant.suivant;
    }
    this.taille--;
    return courant.donnee;
  }

  /**
   * @author Nanche Thibaud
   *         Retourne l'élément à l'indice spécifié dans la liste.
   * 
   * @param i l'indice de l'élément à retourner
   * @return l'élément à l'indice spécifié dans la liste
   * @throws IndexOutOfBoundsException si l'indice est invalide
   */
  public T element(int i) {
    if (i < 0 || i >= this.taille) {
      throw new IndexOutOfBoundsException("L'index spécifié est invalide.");
    }
    Maillon courant = this.tete;
    for (int j = 0; j < i; j++) {
      courant = courant.suivant;
    }
    return courant.donnee;
  }

  /**
   * @author Nanche Thibaud
   * Vérifie si la liste contient un certain élément.
   * 
   * @param e l'élément à rechercher dans la liste
   * @return true si l'élément est présent dans la liste, false sinon
   */
  public boolean contient(T e) {
    Maillon courant = this.tete;
    while (courant != null) {
      if (courant.donnee.equals(e)) {
        return true;
      }
      courant = courant.suivant;
    }
    return false;
  }
}
