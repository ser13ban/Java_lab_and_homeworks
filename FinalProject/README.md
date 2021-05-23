# Laboratorul 11

O reimplementare a laboratorului 10 ca un serviciu web rest folosind Spring boot si structura clasica MVC din acest framework

## Compulsory

- Crearea unei baze de date pentru a retine datele despre utilizatorii nostri si despre prietenii acestora
- implementarea serviciilor rest pentur operatiile crud peste baza de date:
  - obtinera listei de persoane via HTTP GET (Read din crud)
  - adaugarea unei noi persoane prin HTTP POST (Create din crud)
  - modificaraea unui user via HTTP PUT (update din crud)
  - stergerea unei persoane via HTTP DELETE (delete din crud)

## Otional

- implementare serviciilor pentru freindships
  - adaugarea unui nou prieten (POST) introducem un body-ul requestului un obiect cu id-ul userului si id-ul prietenului si se adauga prietenia dintre acestia
  - stergerea unei prietenii (DELETE)
  - listarea tututor pritenilor unui user (GET) - se introduce in link id-ul userului
  - gasierea celei mai populare persoane din retea (GET)
