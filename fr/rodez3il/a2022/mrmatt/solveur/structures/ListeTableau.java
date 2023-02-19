package fr.rodez3il.a2022.mrmatt.solveur.structures;

public class ListeTableau<E> implements Liste<E> {

  // Constante pour la capacité original du tableau
  private static final int originalSize = 10;

  // tableau d'objet
  private E[] tab;
  // taille du tableau;
  private int taille;

  public ListeTableau() {
    this.tab = (E[]) (new Object[originalSize]);
    /***
    *La variable taille est initialisée à zéro car une liste vide est une liste 
    *qui ne contient aucun élément.
    ***/
    this.taille = 0;
  }

  /**
   *@autor Nanche Thibaud
   * Ajoute un élément à la liste.
   * 
   * @param element l'élément à ajouter
   */
  @Override
  public void ajouter(E element) {
    if (this.taille == this.tab.length)
      redimensionner();

    this.tab[taille] = element;
    this.taille++;
  }

  /**
   *@autor Nanche Thibaud
   * Elle crée un nouveau tableau de taille deux fois plus grande que le tableau 
   *actuel,
   *puis copie tous les éléments du tableau actuel dans le nouveau tableau.
   *Enfin, elle remplace le tableau actuel par le nouveau tableau créé.
   */
  private void redimensionner() {

    E[] NouveauTab = (E[]) (new Object[this.tab.length * 2]);

    for (int i = 0; i < this.tab.length; i++)
      NouveauTab[i] = this.tab[i];

    this.tab = NouveauTab;
  }

  /**
   *@autor Nanche Thibaud
   * Indique si la liste est vide.
   * 
   * @return true si la liste est vide.
   */
  @Override
  public boolean estVide() {
    return this.taille == 0;
  }

  /**
   *@autor Nanche Thibaud
   * Indique la taille de la liste.
   * 
   * @return La taille de la liste.
   */
  @Override
  public int taille() {
    return this.taille;
  }

  /**
   *@autor Nanche Thibaud
   * Enlève (et retourne) l'élément à la position i.
   * 
   * @param i la position de l'élément.
   * @return L'élément qui a été supprimé.
   * @throws IndexOutOfBoundsException si l'index est invalide
   */
  @Override
  public E enlever(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= taille) {
      throw new IndexOutOfBoundsException("L'index spécifié est invalide.");
    }

    E elementSupprime = this.tab[i];

    for (int j = i; j < this.taille - 1; j++) {
      this.tab[j] = this.tab[j + 1];
    }

    this.tab[this.taille - 1] = null;
    this.taille--;

    return elementSupprime;
  }

  /**
   *@autor Nanche Thibaud
   * Renvoie l'élément à la position i.
   * 
   * @param i la position de l'élément
   * @return L'élément à la position i
   * @throws IndexOutOfBoundsException si l'index est invalide
   */
  @Override
  public E element(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= taille) {
      throw new IndexOutOfBoundsException("L'index spécifié est invalide.");
    }

    return this.tab[i];
  }

  /**
  *@autor Nanche Thibaud
  *Indique si un élément équivalent à celui passé en paramètre est présent dans la 
  *liste.
  *par leur méthode equals.
  *@param element L'élément à comparer.
  *@return true si un élément équivalent est présent dans la liste, false sinon.
*/
  @Override
  public boolean contient(E e) {
    for (int i = 0; i < this.taille; i++) {
      if (this.tab[i] != null && this.tab[i].equals(e)) {
        return true;
      }
    }
    return false;
 }
}
