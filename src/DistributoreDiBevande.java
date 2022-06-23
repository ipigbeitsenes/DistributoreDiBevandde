public class DistributoreDiBevande {
    private double saldoAttuale;

    private Prodotto[] listaProdotti;


    public DistributoreDiBevande(int n) {
        this.saldoAttuale = 0;
        this.listaProdotti = new Prodotto[n];
    }


    public void caricaProdotto(Prodotto p) {// dato un Prodotto p in input, lo carica nel distributore
        for (int i = 0; i < listaProdotti.length; i++) {
            if (listaProdotti[i] == null) {
                listaProdotti[i] = p;
                break;
            }
        }
    }

    public void inserisciImporto(double importo) { //  inserisciImporto: permette di inserire un importo nella macchinetta
        this.saldoAttuale += importo;

    }

    public Prodotto scegliProdotto(String codice) {
        //    scegliProdotto: dato in ingresso un codice di prodotto,
        //            restituisca il prodotto associato a quel codice (se l’importo inserito lo consente)
        //    e decrementi il saldo disponibile nel distributore

        for (int i = 0; i < listaProdotti.length; i++) {
            if (listaProdotti[i] != null && listaProdotti[i].getCodice().equals(codice) && listaProdotti[i].getPrezzo() <= saldoAttuale) {
                Prodotto myProdotto = listaProdotti[i];
                saldoAttuale -= listaProdotti[i].getPrezzo();
                listaProdotti[i] = null;
                return myProdotto;
            }
        }
        return null;
    }

    public double saldoAttuale() { //restituisce il saldo attuale del distributore
        return saldoAttuale;
    }

    public double getResto() { //restituisce il resto dovuto e azzeri il saldo
        double resto = saldoAttuale;
        saldoAttuale = 0;
        return resto;
    }

}
