# Laboratorul 10

Am implementat o retea sociala rudimentara cu urmatore comezni valabile pentru utilizaori (clienti):

- register nume: adauga o persoana la reteaua sociala, se asigura ca acea persoana nu exista deja in retea
- login name: stabileste o conexiune intre server si usercul cu acel nume
- friend name1 name2... : aduaga in lista de prieteni ai userului logat numele date ca parametrii
- send mesaj: trimite un mesaj tututor prientenilor userului conectat
  -read: citeste mesajele userului;
  -exit: opreste conexiunea curenta a uerului;
  -stop: aceasta commanda cred ca este menita pentru un user ADMIN care poate opri conexsiune pentru toti clienti din retaua sociala

## Tema Compulsory

    Am creat doua aplicatii una pentru server si cealalta pentru client

### aplicatia Server

    - creaza un thread nou pentru fiecare client in parte si primeste requesturi de la clienti pentru care trimite si rapsunsuri aferente.
    - stocheaza reteaua sociala (serverul ar trebui sa ruleze la infinit odata cu oprirea serverului se pired si toate datale clientilor)

### aplicatia Client

    - se conecteaza la server
    - citeste comenzi de la utiliztor intr-o bucla (pana la comanda exit sau oeventuala oprire a serverului)
    - trimite requesturi catre server
    - primeste raspunsuri pe care le afiseaza utilizatorului

## Tema optionala

### implementarea tuturor comenzilor:

- register: adauga un user in ArrayListul de useri
- login: verifica daca acel user exista intre utilizaori inregistrati in retea si stabileste conexiunea pastrand numele clientului pentru acel thread
- friend: adauga prieteni in lista de prieteni din calsa Usser pentru userul curent (doar daca userul curent este conectat)
- read: daca userul este conecatat citeste toate mesajele de la prietenii sai
- exit: opreste conexiunea curenta (termina threadul pentru clientul curent)
- stop: opreste conexiunea pentru toate threadurile curente

### timeout

daca serverul nu primeste nicio comada de la o anumita conexiume pentru mai mult de 3 minute acea conexiune se termina

### HTML embedable represantion

am folosit JgraphT pentru a construi un graph pe baza ArrayListului de Useri unde nodurile sunt numele utilizatorilor si muchiile sunt relatiile de prientenie dintrea acestia (nu am reusit inca sa fac export inntr-un format HTML pentu graf)
