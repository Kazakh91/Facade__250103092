public class FlightBookingFacade
{
    private final SeatInventorySystem seatInventorySystem;
    private final PaymentProcessor paymentProcessor;
    private final BaggagePricingEngine baggagePricingEngine;
    private final TicketIssuer ticketIssuer;
    private final CurrencyConverter currencyConverter;
    public FlightBookingFacade(){
        this.seatInventorySystem  = new SeatInventorySystem();
        this.currencyConverter = new CurrencyConverter();
        this.paymentProcessor = new PaymentProcessor();
        this.ticketIssuer = new TicketIssuer();
        this.baggagePricingEngine = new BaggagePricingEngine();
    }
    public String bookFlight(String passengerName,
                             String flightCode,
                             String seatNumber,
                             double baseFareUSD,
                             int bagCount,
                             double bagWeightKg,
                             String currency,
                             String cardNumber){
        String lockToken = null;
         try {
             seatInventorySystem.connectToReservationServer();
             lockToken = seatInventorySystem.lockSeat(flightCode,seatNumber,passengerName);
             double totalUSD = baggagePricingEngine.calculateBaggageFeeUSD(bagCount,bagWeightKg);
             double convertTotal = currencyConverter.convertFromUSD(totalUSD,currency);
             paymentProcessor.initializeGateway();
             paymentProcessor.chargeCard(cardNumber,convertTotal,currency);
         }

    }
}


