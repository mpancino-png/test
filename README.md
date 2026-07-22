# Kinantobio Resort - Guest Guide Web App

Una moderna web application Java basata su Spring Boot che fornisce ai tuoi ospiti informazioni dettagliate sui punti di interesse, ristoranti, spiagge, musei e attrazioni vicino a **Kinantobio Resort** ad **Ispica, Sicilia**.

## 🎯 Caratteristiche

- **API REST completa** per gestire punti di interesse
- **Ricerca avanzata** per categoria, nome, distanza
- **Calcolo automatico** della distanza dal resort
- **Sistema di rating** con recensioni
- **Database relazionale** con persistenza dati
- **CORS abilitato** per accesso frontend da diversi domini
- **Logging dettagliato** di tutte le operazioni
- **Documentazione API** con endpoint ben strutturati

## 📋 Requisiti

- Java 17+
- Maven 3.6+
- Spring Boot 3.1.5

## 🚀 Avvio Rapido

### 1. Clonare il repository
```bash
git clone https://github.com/mpancino-png/test.git
cd test
```

### 2. Compilare il progetto
```bash
mvn clean install
```

### 3. Avviare l'applicazione
```bash
mvn spring-boot:run
```

L'applicazione sarà disponibile a: `http://localhost:8080/api`

## 📚 API Endpoints

### Resort Information
- **GET** `/resort/info` - Informazioni generali del resort
- **GET** `/resort/coordinates` - Coordinate geografiche del resort
- **GET** `/resort/health` - Health check

### Points of Interest
- **GET** `/points-of-interest` - Lista tutti i punti di interesse
- **GET** `/points-of-interest/{id}` - Dettagli di un singolo punto
- **GET** `/points-of-interest/category/{category}` - Punti per categoria
- **GET** `/points-of-interest/search?name={nome}` - Ricerca per nome
- **GET** `/points-of-interest/nearby?maxDistance={km}` - Punti nelle vicinanze
- **GET** `/points-of-interest/top-rated?limit={numero}` - Migliori valutazioni
- **POST** `/points-of-interest` - Creare nuovo punto
- **PUT** `/points-of-interest/{id}` - Aggiornare un punto
- **DELETE** `/points-of-interest/{id}` - Eliminare un punto (soft delete)

## 📍 Esempi di Utilizzo

### Ottenere informazioni del resort
```bash
curl http://localhost:8080/api/resort/info
```

### Ottenere tutti i punti di interesse
```bash
curl http://localhost:8080/api/points-of-interest
```

### Cercare punti per categoria (es. Ristoranti)
```bash
curl http://localhost:8080/api/points-of-interest/category/Ristorante
```

### Ricerca per nome
```bash
curl "http://localhost:8080/api/points-of-interest/search?name=spiaggia"
```

### Punti di interesse nelle vicinanze (5 km)
```bash
curl "http://localhost:8080/api/points-of-interest/nearby?maxDistance=5"
```

### Migliori punti valutati
```bash
curl "http://localhost:8080/api/points-of-interest/top-rated?limit=10"
```

### Creare un nuovo punto di interesse
```bash
curl -X POST http://localhost:8080/api/points-of-interest \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Nuovo Ristorante",
    "category": "Ristorante",
    "description": "Descrizione del ristorante",
    "latitude": 36.7200,
    "longitude": 15.1950,
    "address": "Via Roma 1, Ispica",
    "phone": "+39 932 123456",
    "website": "https://example.com",
    "openingHours": "12:00-15:00, 19:00-23:00",
    "distanceFromResort": 0.5,
    "estimatedTravelTimeMinutes": 2,
    "rating": 4.5,
    "reviews": 50
  }'
```

## 🗄️ Struttura del Database

### Tabella: points_of_interest
- `id` - ID univoco
- `name` - Nome del punto di interesse
- `category` - Categoria (Spiaggia, Ristorante, Museo, etc.)
- `description` - Descrizione dettagliata
- `latitude` - Latitudine
- `longitude` - Longitudine
- `address` - Indirizzo completo
- `phone` - Numero di telefono
- `website` - Sito web
- `opening_hours` - Orari di apertura
- `distance_from_resort` - Distanza dal resort in km
- `estimated_travel_time` - Tempo di viaggio stimato in minuti
- `rating` - Valutazione (1-5)
- `reviews` - Numero di recensioni
- `active` - Stato attivo/inattivo
- `created_at` - Data di creazione
- `updated_at` - Data di ultimo aggiornamento

## 🛠️ Configurazione

File: `src/main/resources/application.properties`

```properties
# Database
spring.datasource.url=jdbc:h2:mem:kinantobiodb
spring.h2.console.enabled=true

# Resort Info
kinantobio.resort.name=Kinantobio Resort
kinantobio.resort.location=Ispica, Sicily
kinantobio.resort.latitude=36.7181
kinantobio.resort.longitude=15.1936
```

## 🏗️ Architettura

```
src/main/java/com/kinantobio/
├── GuestGuideApplication.java       # Main application
├── model/
│   ├── PointOfInterest.java        # Entity JPA
│   └── dto/
│       └── PointOfInterestDTO.java # Data Transfer Object
├── repository/
│   └── PointOfInterestRepository.java # JPA Repository
├── service/
│   ├── PointOfInterestService.java    # Business Logic
│   └── MapCalculationService.java     # Geographic calculations
└── controller/
    ├── PointOfInterestController.java # REST Endpoints for POI
    └── ResortController.java          # REST Endpoints for Resort
```

## 📦 Categorie Disponibili

- **Spiaggia** - Spiagge e aree balneari
- **Ristorante** - Ristoranti e trattorie
- **Museo** - Musei e collezioni
- **Monumento** - Monumenti storici
- **Attività** - Attività e intrattenimento
- **Borgo** - Borghi e villaggi
- **Naturale** - Aree naturali protette

## 🔍 Calcolo Distanze

L'app utilizza la **formula di Haversine** per calcolare distanze accurate tra coordinate geografiche. Anche il tempo di viaggio è calcolato automaticamente assumendo una velocità media di 60 km/h in auto.

## 🌐 CORS Configuration

L'API è configurata per accettare richieste da qualsiasi origine (CORS abilitato su tutti gli endpoint).

## 📝 Logging

L'app genera log dettagliati per debug e monitoraggio:
- **Level INFO** - Operazioni principali
- **Level DEBUG** - Dettagli applicazione
- **Level ERROR** - Errori e problemi

Visualizza i log in console durante l'esecuzione.

## 🚀 Deploy

Per deploy in produzione:

1. Cambia il database da H2 a PostgreSQL in `application.properties`
2. Configura le variabili di ambiente per le credenziali database
3. Compila con: `mvn clean package -DskipTests`
4. Esegui il JAR: `java -jar target/guest-guide-1.0.0.jar`

## 📞 Supporto

Per domande o problemi, contatta lo sviluppatore.

---

**Kinantobio Resort** - Benvenuti nella Sicilia autentica! 🏖️✨