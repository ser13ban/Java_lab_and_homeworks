# Laboratorul 1

## Tema optionala

Am implementat graful printr-o matrice de adiacenta (simetrica dupa diagonala principala) pe care am initlizat-o random ( probalbilitate 50% sa avem muchie in aceea pozitie)

Pentru a verifica daca graful nostru este conex am folosit un vector vizitat (initializat cu 0 peste tot) si o metoda clasica de parcurgere a unui graf (DFS)
Intr-un for de la primul la ultimul nod, daca nodul nostru curent nu este vizitat pornim o parcurgere DFS dn acea pozitie, de fiecare data cand apelam functia DFS crestem un contor ( numarul total de componente conexe). De asemenea functia noastra DFS afiseaza nodurile unei componente conexe.
Daca contorul nostru creste o singura data inseaman ca graful este conex altfel de pentru fiecare componenta conexa au fost afisate anterior nodurile din componenta
