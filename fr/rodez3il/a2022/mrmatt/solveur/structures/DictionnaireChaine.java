package fr.rodez3il.a2022.mrmatt.solveur.structures;
/**
 * @author Nanche Thibaud
 * Je tiens à préciser que il y avait d'autre alternative plus simple
 * comme import java.util.LinkedList;  :(
 * Une implémentation de l'interface Dictionnaire basée sur une liste
 * chaînée.
 * Les clés et les valeurs sont de types génériques C et V.
 */
public class DictionnaireChaine<C, V> implements Dictionnaire<C, V> {

  /**
   * @author Nanche Thibaud
   * Une entrée dans le dictionnaire qui associe une clé de type C et une
   * valeur de type V.
   */
  private class Entree<C,V> {
    private C cle;
    private V valeur;

    /**
     * @author Nanche Thibaud
     * Crée une nouvelle entrée avec la clé et la valeur spécifiées.
     *
     * @param cle    la clé associée à cette entrée
     * @param valeur la valeur associée à cette entrée
     */
    public Entree(C cle, V valeur) {
      this.cle = cle;
      this.valeur = valeur;
    }

    public C getCle() {
      return cle;
    }

    public V getValeur() {
      return valeur;
    }
  }

  /***
   * Une liste chaînée pour stocker les entrées du dictionnaire
   */
  private ListeChainee<Entree<C,V>> liste = new ListeChainee<>();

  private int tailleDictionnaire;


  public DictionnaireChaine(ListeChainee<Entree<C, V>> liste) {
    this.liste = liste;
    this.tailleDictionnaire=0;
  }

  /**
   * Redimensionne la liste en doublant sa capacité.
   */


  /**
   * @author Nanche Thibaud
   * Ajoute un couple clé-valeur au dictionnaire. Si la clé existe déjà,
   * sa valeur est mise à jour.
   *
   * @param cle    la clé à ajouter ou à mettre à jour
   * @param valeur la valeur associée à la clé
   */
  @Override
  public void inserer(C cle, V valeur) throws IllegalArgumentException{
    Entree existante = null;

    // recherche d'une entrée existante avec la clé donnée
    if(this.contient(cle)){
      throw new IllegalArgumentException("La clé existe déjà ");
    }

    if (existante != null) {
      // une entrée avec la clé donnée existe déjà, met à jour sa valeur
      existante.valeur = valeur;
    } else {
      // la clé n'existe pas encore, ajoute une nouvelle entrée
      liste.ajouter(new Entree(cle, valeur));
    }
  }

  /**
   * @author Nanche Thibaud
   * Vérifie si le dictionnaire contient une entrée avec la clé spécifiée.
   *
   * @param cle la clé à rechercher
   * @return true si une entrée avec la clé donnée est présente, false sinon
   */
  @Override
  public boolean contient(C cle) {
      boolean resultat =false;
      for(int i = 0; i<this.tailleDictionnaire; i++){
          if(this.liste.element(i).getCle().equals(cle)){
             resultat=true;
          }
      }
      return resultat;
  }

  /**
   * @author Nanche Thibaud
   * Renvoie la valeur associée à la clé donnée, ou null si la clé n'est
   * pas présente dans le dictionnaire.
   *
   * @param cle la clé dont la valeur est recherchée
   * @return la valeur associée à la clé donnée, ou null si la clé n'est pas
   *         présente
   */
  @Override
  public V valeur(C cle) {
    V resultat = null;
    for(int i = 0; i<this.tailleDictionnaire; i++){
      if(this.liste.element(i).getCle().equals(cle)){
        resultat=this.liste.element(i).getValeur();
      }
    }
    return resultat;
  }
}