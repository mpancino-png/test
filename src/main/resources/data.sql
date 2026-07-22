-- Inserimento di dati di esempio per i punti di interesse vicino a Ispica

-- Spiagge
INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Spiaggia di Ispica', 'Spiaggia', 'Una bellissima spiaggia sabbiosa con acque cristalline, perfetta per famiglie e appassionati di nuoto.', 36.7201, 15.1956, 'Lungomare di Ispica', '+39 932 123456', 'https://www.ispica.it', '08:00-19:00', 1.2, 5, 4.8, 245, true);

INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Spiaggia di Micenci', 'Spiaggia', 'Spiaggia selvaggia e affascinante, ideale per chi cerca tranquillità e bellezza naturale.', 36.7150, 15.2100, 'Contrada Micenci, Ispica', '', '', '', 3.5, 8, 4.5, 120, true);

-- Ristoranti
INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Ristorante Il Gabbiano', 'Ristorante', 'Ristorante fronte mare specializzato in pesce fresco. Piatti tipici della cucina siciliana con vista panoramica.', 36.7195, 15.1945, 'Via Lungomare 25, Ispica', '+39 932 654321', 'https://ilgabbiano-ispica.it', '12:00-15:00, 19:00-23:00', 0.8, 3, 4.7, 189, true);

INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Trattoria da Nonna Maria', 'Ristorante', 'Autentica cucina siciliana in un ambiente familiare e accogliente. Specialità: arancini, pasta alla Norma, caponata.', 36.7180, 15.1920, 'Via Roma 12, Ispica', '+39 932 789012', '', '12:00-14:30, 19:00-22:30', 0.5, 2, 4.6, 156, true);

INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Pizzeria da Antonio', 'Ristorante', 'Pizzeria tradizionale con forno a legna. Pizza napoletana autentica e ingredienti di qualità.', 36.7175, 15.1935, 'Via Garibaldi 8, Ispica', '+39 932 345678', 'https://pizzeria-antonio.it', '18:00-23:00', 0.3, 1, 4.4, 98, true);

-- Musei e Monumenti
INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Chiesa di Santa Maria Maggiore', 'Monumento', 'Suggestiva chiesa barocca con facciata splendida e ricchi interni affrescati. Testimonianza dell''arte barocca siciliana.', 36.7185, 15.1925, 'Piazza Centrale, Ispica', '+39 932 456789', '', '09:00-12:00, 16:00-19:00', 0.4, 2, 4.5, 87, true);

INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Museo di Ispica', 'Museo', 'Museo locale con collezioni di reperti archeologici, arte e tradizioni siciliane. Una finestra sulla storia della valle dell''Ippari.', 36.7190, 15.1915, 'Via Museo 5, Ispica', '+39 932 567890', 'https://museo-ispica.it', '10:00-13:00, 15:00-18:00', 0.6, 2, 4.3, 64, true);

INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Cava d''Ispica', 'Monumento', 'Suggestiva necropoli preistorica scavata nella roccia. Sito archeologico di grande valore storico con tombe rupestri e insediamenti antichi.', 36.7220, 15.1890, 'Strada Provinciale Cava d''Ispica, Ispica', '+39 932 678901', 'https://cavadispica.it', '09:00-17:00', 2.0, 5, 4.6, 142, true);

-- Attività e Attrazioni
INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Centro Subacqueo Dive Center', 'Attività', 'Centro per immersioni subacquee con istruttori certificati. Scopri la fauna marina della costa siciliana.', 36.7200, 15.1950, 'Porto di Ispica', '+39 932 789123', 'https://divecentero-ispica.it', '08:00-18:00', 1.5, 4, 4.7, 93, true);

INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Mercato Settimanale', 'Attività', 'Colorato mercato settimanale con prodotti locali, frutta, verdura e artigianato siciliano. Aperto il giovedì mattina.', 36.7170, 15.1910, 'Piazza del Mercato, Ispica', '', '', '07:00-13:00 (giovedì)', 0.7, 2, 4.2, 75, true);

-- Villaggi e Borghi
INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Modica - Patrimonio UNESCO', 'Borgo', 'Splendido borgo barocco a soli 20 km, patrimonio UNESCO. Celebre la sua scalinata monumentale e l''architettura barocca affascinante.', 36.7470, 15.0800, 'Modica, Ragusa', '', '', '', 20.0, 25, 4.8, 287, true);

INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Ragusa Ibla - Patrimonio UNESCO', 'Borgo', 'Incantevole centro barocco con piazze eleganti e architettura rinascimentale. A 15 km da Ispica.', 36.8800, 14.7300, 'Ragusa, Ragusa', '', '', '', 22.0, 28, 4.7, 312, true);

-- Naturale
INSERT INTO points_of_interest (name, category, description, latitude, longitude, address, phone, website, opening_hours, distance_from_resort, estimated_travel_time, rating, reviews, active) 
VALUES ('Riserva Naturale della Foce del Dirillo', 'Naturale', 'Area naturale protetta con ecosistemi lacustri e foce fluviale. Paradiso per birdwatching e natura incontaminata.', 36.7100, 15.2500, 'Contrada Foce Dirillo, Ispica', '', '', '08:00-sunset', 5.5, 12, 4.4, 101, true);