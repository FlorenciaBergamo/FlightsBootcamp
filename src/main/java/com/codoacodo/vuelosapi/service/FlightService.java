package com.codoacodo.vuelosapi.service;

import com.codoacodo.vuelosapi.configuration.FlightConfiguration;
import com.codoacodo.vuelosapi.model.Flight;
import com.codoacodo.vuelosapi.model.FlightDto;
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


    //public List<FlightDto> findAll(){
//    double price = getDollar();
//    List<FlightDto> flightDtos = new ArrayList<>();
//    List<Flight> flights = flightRepository.findAll();
//    for(Flight f: flights){
//    flightDtos.add(flightUtils.flightMapper(f, price));
//    }
//    return flightDtos;
//}
// ESTO ES IGUAL A LO DE ARRIBA, pero con STREAM:
//    public List<FlightDto> findAll() {
//        List<Flight> flightList = flightRepository.findAll();
//        List<FlightDto> flightDtoList = flightList.stream()
//                .map(flight -> flightUtils.flightMapper(flight, getDolar()))
//                .collect(Collectors.toList());
//        return flightDtoList;
//    }
//    ESTO ES IGUAL A LO DE ARRIBA, resumido:
//    public List<FlightDto> findAll() {
//        return flightRepository.findAll().stream()
//                .map(flight -> flightUtils.flightMapper(flight,getDollar()))
//                .collect(Collectors.toList());
//    }
    // ESTO ES IGUAL A LO DE ARRIBA, PERO LLAMANDO AL METODO DE UTILS.
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

  /*  @Autowired
    CompanyRepository companyRepository;*/

/*    public List<FlightDto> findAll() {
        List<Flight> flightList = flightRepository.findAll();
        return flightList.stream()
                .map(flight -> flightUtils.flightMapper(flight,getDolar()))
                .collect(Collectors.toList());
    }*/

//    public Flight createFlight(Flight flight, Long companyId) {
//        Company company = companyRepository.findById(companyId)
//                .orElseThrow(() -> new IllegalArgumentException("Company not found"));
//
//        flight.setCompany(company);
//        return flightRepository.save(flight);
//    }


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
//    public Optional<Flight> update(Flight flight) {
//        flightRepository.save(flight);
//        return flightRepository.findById(flight.getId());
//    }


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

