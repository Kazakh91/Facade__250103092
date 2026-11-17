public class FlightBookingFacade
{
    private final SeatInventorySystem seatInventorySystem;
    private PaymentProcessor paymentProcessor;
    private BaggagePricingEngine baggagePricingEngine;
    private TicketIssuer ticketIssuer;
    private CurrencyConverter currencyConverter;
    public SeatInventorySystem SeatInventorySystem{
        this.seatInventorySystem =  new SeatInventorySystem();
    }

    public PaymentProcessor PaymentProcessor{
        this.paymentProcessor = new PaymentProcessor();
    }
    public BaggagePricingEngine BaggagePricingEngine{
        this.baggagePricingEngine = new BaggagePricingEngine();
}

    public TicketIssuer TicketIssuer{
        this.ticketIssuer = new TicketIssuer();
    }

    public CurrencyConverter CurrencyConverter() {
        this.currencyConverter = new CurrencyConverter();
    }
    public String bookFlight(String passengerName,
                             String flightCode,
                             String seatNumber,
                             double baseFareUSD,
                             int bagCount,
                             double bagWeightKg,
                             String currency,
                             String cardNumber)  {

    }
}


