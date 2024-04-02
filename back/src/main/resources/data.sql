
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

              
INSERT INTO reprezentacija (id, naziv, skraceni_naziv) VALUES (1, 'Vanuatu', 'VNT');
INSERT INTO reprezentacija (id, naziv, skraceni_naziv) VALUES (2, 'DR Kongo', 'DRK');
INSERT INTO reprezentacija (id, naziv, skraceni_naziv) VALUES (3, 'DNR Koreja', 'DNK');
INSERT INTO reprezentacija (id, naziv, skraceni_naziv) VALUES (4, 'Vijetnam', 'VIE');

INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, golovia, golovib) VALUES (1, 1, 2, 2, 0);
INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, golovia, golovib) VALUES (2, 3, 4, 1, 2);
INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, golovia, golovib) VALUES (3, 1, 3, 2, 0);
INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, golovia, golovib) VALUES (4, 2, 4, 1, 2);
INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, golovia, golovib) VALUES (5, 1, 4, 1, 2);
INSERT INTO utakmica(id, reprezentacijaa_id, reprezentacijab_id, golovia, golovib) VALUES (6, 2, 3, 1, 2);

INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (1, 'Igbolo', 'Igbolo', 0, 1);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (2, 'Udo', 'Aru', 1, 1);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (3, 'Bolo', 'Bol', 1, 1);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (4, 'Samuel', 'Samuelsen', 0, 2);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (5, 'Eto', 'Eto', 0, 2);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (6, 'Baba', 'Baba', 0, 2);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (7, 'Kim', 'Kiim', 0, 3);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (8, 'Son', 'Soon', 0, 3);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (9, 'Sung', 'Sunng', 0, 3);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (10, 'Mao', 'Maao', 0, 4);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (11, 'Tao', 'Taao', 0, 4);
INSERT INTO igrac(id, ime, prezime, postignuti_golovi, reprezentacija_id) VALUES (12, 'Dao', 'Daao', 0, 4);




