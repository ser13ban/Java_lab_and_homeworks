# Laboratorul 5

## Tema optionala

Am implementat o plicatie de tip consola pentru interactiunea cu un catalog ce poate contine diferite tipuri de fisiere.

Meniul contine 7 comenzi fiecare cu parametrii ei

### AddCommand

primeste ca parametri un path si un nume si adauga in catalog un nou fisier cu acel path si cu acel nume -- se face verificarea parametrilor ( path-ul trebuie sa fie valid);

### ListCommand

nu primeste niciun parametru, listeaza toata elementele din catalog dupa nume;

### PlayCommand

Primeste ca argument numele unui obiect din catalog si deschide acel fisier cu aplicatia implicita

### SaveCommand

Salveaza catalogul catre un fisier extern (catalog.txt) folosind serializarea;

### LoadCommand

Primeste ca parametru un path catre un fisier si incaraca un catalog din acel fisier (folsind deserializarea);

### ReportCommand

Nu primeste niciun parametru, creaza un raport intr-un fisier html continand date despre catalogul curent, deasemea deschide fisierul html cu aplicatia implicita. (am folosit libraria externa FreeMarker);

### Quit

Nu primeste niciun parametru, inchide meniul si executia programului.

### Custom Exceptions

#### NotValidCommand

NotValidCommad arumca exceptii pentru comenzile invalida, o comanda poate fi invalida daca:

- nu face parte din comezile recunoscute ( list, add, save, load, quit, report, play);
- path-ul intorus pointeaza catre un fisier inexsitent sau este invalid
- numarul de parametrii introdusi pentru o comanda este prea mare

### AlreadyExistExceotion

In cazul in care utilizatorul doreste sa adauge un fisier in catalog cu un nume care este deja existent in catalog se arunca o exceptie custom de tipul AreadyExistException
