# Laboratorul 3

## Tema optionala

### Metoda care afiseaza locatiile care sunt vizitabile dar nu si platibile sortate dupa ora deschiderii

Pentru implementarea acestei metode am suprascis metoda to compare din clasa location (in momentul de faca verifica daca obiectele de comparat implementeaza interfata Vizitable si compoara ora de deschidere). Urmand ca un metoda sa folosim functia sort din Colections.

### Metoda default in interfata Vizitable care seteaza orele e deschidere si inchidere

Aceasata metoda apeleaza doua metode deja existente in interfata (metodele de set pentru ora de deschidere si cea de inchidere)

### Clasa TravelPlan

Aceasta calsa contine o instanta a unui City si obine de la consola preferintele pentru fiecare locatie din oras ( memoreaza aceste informatii inntr-un array de integer)

### Cel mai scurt drum dintre doua locatii in conformitate cu preferintele

Am implementat un algoritm recursiv asemenator cu Dijkstra
Comparam de fiecare data doua locatii in functie de preferinta iar mai apoi in functie de cost (in cazul de egalitate)
