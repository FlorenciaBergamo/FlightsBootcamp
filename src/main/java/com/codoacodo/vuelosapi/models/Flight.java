package com.codoacodo.vuelosapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String origin;
   private String destiny;
   private LocalDateTime departureTime;
   private LocalDateTime arrivingTime;
   private double price;
   private String frequency;
   @ManyToOne
   @JoinColumn(name = "company_id")
   private Company company;

   public Flight(String origin, String destiny, LocalDateTime departureTime, LocalDateTime arrivingTime, double price, String frequency) {
      this.origin = origin;
      this.destiny = destiny;
      this.departureTime = departureTime;
      this.arrivingTime = arrivingTime;
      this.price = price;
      this.frequency = frequency;
   }
}

//{"origin": "Argentina",
//"destiny": "Brasil",
//"departureTime": "2024-03-09T18:00:00",
//"arrivingTime": "2024-03-09T22:00:00",
//"price": 150,
//"frequency": "Semanal"
//}