public class Person {
    private String prenom;
    private String nom;
    private String adrMail;
    
    public Person(String prenom,String nom,String adrMail){
        this.prenom=prenom;
        this.nom=nom;
        this.adrMail=adrMail;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdrMail() {
        return adrMail;
    }
    public void setAdrMail(String adrMail) {
        this.adrMail = adrMail;
    }
    @Override
    public String toString() {
        return "Person [prenom=" + prenom + ", nom=" + nom + ", adrMail=" + adrMail + "]";
    }
    
}