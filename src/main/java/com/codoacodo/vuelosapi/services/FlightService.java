package com.codoacodo.vuelosapi.services;

import com.codoacodo.vuelosapi.configuration.FlightConfiguration;
import com.codoacodo.vuelosapi.models.Company;
import com.codoacodo.vuelosapi.models.Flight;
import com.codoacodo.vuelosapi.models.FlightDto;
import com.codoacodo.vuelosapi.repository.CompanyRepository;
import com.codoacodo.vuelosapi.repository.FlightRepository;
import com.codoacodo.vuelosapi.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightUtils flightUtils;

    @Autowired
    FlightConfiguration flightConfiguration;
    @Autowired
    CompanyRepository companyRepository;

    public List<FlightDto> findAll() {
        double price = getDollar();
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.flightMapper(flights, price);
    }

        public List<Flight> getAllFlights () {
            return flightRepository.findAll();
        }

        public void addFlight (Flight flight){
            flightRepository.save(flight);
        }


    public Flight createFlight(Flight flight, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Company not found"));

        flight.setCompany(company);
        return flightRepository.save(flight);
    }


//    public Optional<Flight> findById(Long id) {
//        return flightRepository.findById(id);
//    }
//
        public void deleteFlightById (Long id){
            flightRepository.deleteById(id);
        }

        public Flight update (Flight flight){
            flightRepository.save(flight);
            return flightRepository.findById(flight.getId()).orElse(null);
        }

        public double getDollar() {
            return flightConfiguration.fetchDollar().getPromedio();
        }

//    public List<Dollar> getAllDollars() {
//       return List.of(flightConfiguration.fetchAllDollars());
//    }
        //List.of ---> para poder pasar cualquier array y transformarlo a lista.


//
//    public  List<Flight> getByOrigin(String origin){
//        return flightRepository.findByOrigin(origin);
//    }
//
//    public  List<Flight> getByOriginAndDestiny(String origin, String destiny){
//        return flightRepository.findByOriginAndDestiny(origin, destiny);
//    }
//*/
/*
    public List<Flight> getOffers(Integer offerPrice){
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.detectOffers(flights, offerPrice);
    }*//*


    public Dolar getDolar() {
        FlightConfiguration flightConfiguration = new FlightConfiguration();
        return flightConfiguration.fetchDolar();
    }
*/

//    public List<Dolar> getAllDolars() {
//        return List.of(flightConfiguration.fetchAllDolars());
//    }

}

