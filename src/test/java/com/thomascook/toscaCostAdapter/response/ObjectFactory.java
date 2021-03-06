//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.28 at 01:25:48 PM EEST 
//


package com.thomascook.toscaCostAdapter.response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.thomascook.toscaCostAdapter.response package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
class ObjectFactory {

    private final static QName _TPAExtensions_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "TPA_Extensions");
    private final static QName _ParagraphTypeImage_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "Image");
    private final static QName _ParagraphTypeURL_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "URL");
    private final static QName _ParagraphTypeText_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "Text");
    private final static QName _ParagraphTypeListItem_QNAME = new QName("http://www.opentravel.org/OTA/2003/05", "ListItem");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.thomascook.toscaCostAdapter.response
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OTAPkgCostRS }
     */
    public OTAPkgCostRS createOTAPkgCostRS() {
        return new OTAPkgCostRS();
    }

    /**
     * Create an instance of {@link PkgFlightSegmentBaseType }
     */
    public PkgFlightSegmentBaseType createPkgFlightSegmentBaseType() {
        return new PkgFlightSegmentBaseType();
    }

    /**
     * Create an instance of {@link ContactPersonType }
     */
    public ContactPersonType createContactPersonType() {
        return new ContactPersonType();
    }

    /**
     * Create an instance of {@link CustomerCountsType }
     */
    public CustomerCountsType createCustomerCountsType() {
        return new CustomerCountsType();
    }

    /**
     * Create an instance of {@link AddressType }
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link DocumentType }
     */
    public DocumentType createDocumentType() {
        return new DocumentType();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail }
     */
    public PkgInvoiceDetail createPkgInvoiceDetail() {
        return new PkgInvoiceDetail();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.DepositAmounts }
     */
    public PkgInvoiceDetail.DepositAmounts createPkgInvoiceDetailDepositAmounts() {
        return new PkgInvoiceDetail.DepositAmounts();
    }

    /**
     * Create an instance of {@link ItineraryItemResponseType }
     */
    public ItineraryItemResponseType createItineraryItemResponseType() {
        return new ItineraryItemResponseType();
    }

    /**
     * Create an instance of {@link VehicleRentalCoreType }
     */
    public VehicleRentalCoreType createVehicleRentalCoreType() {
        return new VehicleRentalCoreType();
    }

    /**
     * Create an instance of {@link ItineraryItemResponseType.Accommodation }
     */
    public ItineraryItemResponseType.Accommodation createItineraryItemResponseTypeAccommodation() {
        return new ItineraryItemResponseType.Accommodation();
    }

    /**
     * Create an instance of {@link ItineraryItemResponseType.Accommodation.RoomProfiles }
     */
    public ItineraryItemResponseType.Accommodation.RoomProfiles createItineraryItemResponseTypeAccommodationRoomProfiles() {
        return new ItineraryItemResponseType.Accommodation.RoomProfiles();
    }

    /**
     * Create an instance of {@link RoomProfileType }
     */
    public RoomProfileType createRoomProfileType() {
        return new RoomProfileType();
    }

    /**
     * Create an instance of {@link ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile }
     */
    public ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile createItineraryItemResponseTypeAccommodationRoomProfilesRoomProfile() {
        return new ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile();
    }

    /**
     * Create an instance of {@link ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile.Prices }
     */
    public ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile.Prices createItineraryItemResponseTypeAccommodationRoomProfilesRoomProfilePrices() {
        return new ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile.Prices();
    }

    /**
     * Create an instance of {@link CabinAvailType }
     */
    public CabinAvailType createCabinAvailType() {
        return new CabinAvailType();
    }

    /**
     * Create an instance of {@link SeatRequestType }
     */
    public SeatRequestType createSeatRequestType() {
        return new SeatRequestType();
    }

    /**
     * Create an instance of {@link SeatRequestType.TPAExtensions }
     */
    public SeatRequestType.TPAExtensions createSeatRequestTypeTPAExtensions() {
        return new SeatRequestType.TPAExtensions();
    }

    /**
     * Create an instance of {@link PackageResponseType }
     */
    public PackageResponseType createPackageResponseType() {
        return new PackageResponseType();
    }

    /**
     * Create an instance of {@link PkgPassengerListItem }
     */
    public PkgPassengerListItem createPkgPassengerListItem() {
        return new PkgPassengerListItem();
    }

    /**
     * Create an instance of {@link FlightSegmentBaseType }
     */
    public FlightSegmentBaseType createFlightSegmentBaseType() {
        return new FlightSegmentBaseType();
    }

    /**
     * Create an instance of {@link OperationScheduleType }
     */
    public OperationScheduleType createOperationScheduleType() {
        return new OperationScheduleType();
    }

    /**
     * Create an instance of {@link OperationScheduleType.OperationTimes }
     */
    public OperationScheduleType.OperationTimes createOperationScheduleTypeOperationTimes() {
        return new OperationScheduleType.OperationTimes();
    }

    /**
     * Create an instance of {@link ItineraryItemRequestType }
     */
    public ItineraryItemRequestType createItineraryItemRequestType() {
        return new ItineraryItemRequestType();
    }

    /**
     * Create an instance of {@link DateTimeSpanType }
     */
    public DateTimeSpanType createDateTimeSpanType() {
        return new DateTimeSpanType();
    }

    /**
     * Create an instance of {@link GuestCountType }
     */
    public GuestCountType createGuestCountType() {
        return new GuestCountType();
    }

    /**
     * Create an instance of {@link MealPlanType }
     */
    public MealPlanType createMealPlanType() {
        return new MealPlanType();
    }

    /**
     * Create an instance of {@link MealPlanType.Prices }
     */
    public MealPlanType.Prices createMealPlanTypePrices() {
        return new MealPlanType.Prices();
    }

    /**
     * Create an instance of {@link SourceType }
     */
    public SourceType createSourceType() {
        return new SourceType();
    }

    /**
     * Create an instance of {@link PaymentFormType }
     */
    public PaymentFormType createPaymentFormType() {
        return new PaymentFormType();
    }

    /**
     * Create an instance of {@link PaymentDetailType }
     */
    public PaymentDetailType createPaymentDetailType() {
        return new PaymentDetailType();
    }

    /**
     * Create an instance of {@link PaymentFormType.LoyaltyRedemption }
     */
    public PaymentFormType.LoyaltyRedemption createPaymentFormTypeLoyaltyRedemption() {
        return new PaymentFormType.LoyaltyRedemption();
    }

    /**
     * Create an instance of {@link AccommodationInfoType }
     */
    public AccommodationInfoType createAccommodationInfoType() {
        return new AccommodationInfoType();
    }

    /**
     * Create an instance of {@link FacilityChoicesType }
     */
    public FacilityChoicesType createFacilityChoicesType() {
        return new FacilityChoicesType();
    }

    /**
     * Create an instance of {@link ParagraphType }
     */
    public ParagraphType createParagraphType() {
        return new ParagraphType();
    }

    /**
     * Create an instance of {@link DirectBillType }
     */
    public DirectBillType createDirectBillType() {
        return new DirectBillType();
    }

    /**
     * Create an instance of {@link RoomPriceType }
     */
    public RoomPriceType createRoomPriceType() {
        return new RoomPriceType();
    }

    /**
     * Create an instance of {@link AccommodationSegmentRequestType }
     */
    public AccommodationSegmentRequestType createAccommodationSegmentRequestType() {
        return new AccommodationSegmentRequestType();
    }

    /**
     * Create an instance of {@link ExtrasCoreType }
     */
    public ExtrasCoreType createExtrasCoreType() {
        return new ExtrasCoreType();
    }

    /**
     * Create an instance of {@link ExtrasInfoType }
     */
    public ExtrasInfoType createExtrasInfoType() {
        return new ExtrasInfoType();
    }

    /**
     * Create an instance of {@link PkgAirSegmentType }
     */
    public PkgAirSegmentType createPkgAirSegmentType() {
        return new PkgAirSegmentType();
    }

    /**
     * Create an instance of {@link PaymentCardType }
     */
    public PaymentCardType createPaymentCardType() {
        return new PaymentCardType();
    }

    /**
     * Create an instance of {@link PackageType }
     */
    public PackageType createPackageType() {
        return new PackageType();
    }

    /**
     * Create an instance of {@link CostingItemType }
     */
    public CostingItemType createCostingItemType() {
        return new CostingItemType();
    }

    /**
     * Create an instance of {@link OTAPkgCostRS.Package }
     */
    public OTAPkgCostRS.Package createOTAPkgCostRSPackage() {
        return new OTAPkgCostRS.Package();
    }

    /**
     * Create an instance of {@link OTAPkgCostRS.Package.AcceptedPaymtForms }
     */
    public OTAPkgCostRS.Package.AcceptedPaymtForms createOTAPkgCostRSPackageAcceptedPaymtForms() {
        return new OTAPkgCostRS.Package.AcceptedPaymtForms();
    }

    /**
     * Create an instance of {@link SuccessType }
     */
    public SuccessType createSuccessType() {
        return new SuccessType();
    }

    /**
     * Create an instance of {@link WarningsType }
     */
    public WarningsType createWarningsType() {
        return new WarningsType();
    }

    /**
     * Create an instance of {@link OTAPkgCostRS.Extras }
     */
    public OTAPkgCostRS.Extras createOTAPkgCostRSExtras() {
        return new OTAPkgCostRS.Extras();
    }

    /**
     * Create an instance of {@link TPAExtensionsType }
     */
    public TPAExtensionsType createTPAExtensionsType() {
        return new TPAExtensionsType();
    }

    /**
     * Create an instance of {@link ErrorsType }
     */
    public ErrorsType createErrorsType() {
        return new ErrorsType();
    }

    /**
     * Create an instance of {@link EmailType }
     */
    public EmailType createEmailType() {
        return new EmailType();
    }

    /**
     * Create an instance of {@link StateProvType }
     */
    public StateProvType createStateProvType() {
        return new StateProvType();
    }

    /**
     * Create an instance of {@link RoomStayCandidateType }
     */
    public RoomStayCandidateType createRoomStayCandidateType() {
        return new RoomStayCandidateType();
    }

    /**
     * Create an instance of {@link OperatingAirlineType }
     */
    public OperatingAirlineType createOperatingAirlineType() {
        return new OperatingAirlineType();
    }

    /**
     * Create an instance of {@link BankAcctType }
     */
    public BankAcctType createBankAcctType() {
        return new BankAcctType();
    }

    /**
     * Create an instance of {@link PkgRoomInventoryType }
     */
    public PkgRoomInventoryType createPkgRoomInventoryType() {
        return new PkgRoomInventoryType();
    }

    /**
     * Create an instance of {@link ExtrasType }
     */
    public ExtrasType createExtrasType() {
        return new ExtrasType();
    }

    /**
     * Create an instance of {@link PkgFlightSegmentType }
     */
    public PkgFlightSegmentType createPkgFlightSegmentType() {
        return new PkgFlightSegmentType();
    }

    /**
     * Create an instance of {@link TimeInstantType }
     */
    public TimeInstantType createTimeInstantType() {
        return new TimeInstantType();
    }

    /**
     * Create an instance of {@link ErrorType }
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link AccommodationDetailType }
     */
    public AccommodationDetailType createAccommodationDetailType() {
        return new AccommodationDetailType();
    }

    /**
     * Create an instance of {@link PersonNameType }
     */
    public PersonNameType createPersonNameType() {
        return new PersonNameType();
    }

    /**
     * Create an instance of {@link PkgCautionType }
     */
    public PkgCautionType createPkgCautionType() {
        return new PkgCautionType();
    }

    /**
     * Create an instance of {@link WarningType }
     */
    public WarningType createWarningType() {
        return new WarningType();
    }

    /**
     * Create an instance of {@link RoomAmenityPrefType }
     */
    public RoomAmenityPrefType createRoomAmenityPrefType() {
        return new RoomAmenityPrefType();
    }

    /**
     * Create an instance of {@link EmployeeInfoType }
     */
    public EmployeeInfoType createEmployeeInfoType() {
        return new EmployeeInfoType();
    }

    /**
     * Create an instance of {@link SourceIdentificationType }
     */
    public SourceIdentificationType createSourceIdentificationType() {
        return new SourceIdentificationType();
    }

    /**
     * Create an instance of {@link OwnInsuranceChoiceType }
     */
    public OwnInsuranceChoiceType createOwnInsuranceChoiceType() {
        return new OwnInsuranceChoiceType();
    }

    /**
     * Create an instance of {@link StreetNmbrType }
     */
    public StreetNmbrType createStreetNmbrType() {
        return new StreetNmbrType();
    }

    /**
     * Create an instance of {@link EquipmentType }
     */
    public EquipmentType createEquipmentType() {
        return new EquipmentType();
    }

    /**
     * Create an instance of {@link PkgTravelSegment }
     */
    public PkgTravelSegment createPkgTravelSegment() {
        return new PkgTravelSegment();
    }

    /**
     * Create an instance of {@link FormattedTextTextType }
     */
    public FormattedTextTextType createFormattedTextTextType() {
        return new FormattedTextTextType();
    }

    /**
     * Create an instance of {@link TicketingInfoRSType }
     */
    public TicketingInfoRSType createTicketingInfoRSType() {
        return new TicketingInfoRSType();
    }

    /**
     * Create an instance of {@link PeriodPriceType }
     */
    public PeriodPriceType createPeriodPriceType() {
        return new PeriodPriceType();
    }

    /**
     * Create an instance of {@link ChargesType }
     */
    public ChargesType createChargesType() {
        return new ChargesType();
    }

    /**
     * Create an instance of {@link SeatAvailabilityType }
     */
    public SeatAvailabilityType createSeatAvailabilityType() {
        return new SeatAvailabilityType();
    }

    /**
     * Create an instance of {@link TaxType }
     */
    public TaxType createTaxType() {
        return new TaxType();
    }

    /**
     * Create an instance of {@link PkgPriceType }
     */
    public PkgPriceType createPkgPriceType() {
        return new PkgPriceType();
    }

    /**
     * Create an instance of {@link FeeType }
     */
    public FeeType createFeeType() {
        return new FeeType();
    }

    /**
     * Create an instance of {@link UniqueIDType }
     */
    public UniqueIDType createUniqueIDType() {
        return new UniqueIDType();
    }

    /**
     * Create an instance of {@link CompanyNameType }
     */
    public CompanyNameType createCompanyNameType() {
        return new CompanyNameType();
    }

    /**
     * Create an instance of {@link TaxesType }
     */
    public TaxesType createTaxesType() {
        return new TaxesType();
    }

    /**
     * Create an instance of {@link FreeTextType }
     */
    public FreeTextType createFreeTextType() {
        return new FreeTextType();
    }

    /**
     * Create an instance of {@link URLType }
     */
    public URLType createURLType() {
        return new URLType();
    }

    /**
     * Create an instance of {@link PropertyIdentityType }
     */
    public PropertyIdentityType createPropertyIdentityType() {
        return new PropertyIdentityType();
    }

    /**
     * Create an instance of {@link POSType }
     */
    public POSType createPOSType() {
        return new POSType();
    }

    /**
     * Create an instance of {@link CountryNameType }
     */
    public CountryNameType createCountryNameType() {
        return new CountryNameType();
    }

    /**
     * Create an instance of {@link AddressInfoType }
     */
    public AddressInfoType createAddressInfoType() {
        return new AddressInfoType();
    }

    /**
     * Create an instance of {@link MonetaryRuleType }
     */
    public MonetaryRuleType createMonetaryRuleType() {
        return new MonetaryRuleType();
    }

    /**
     * Create an instance of {@link TicketingInfoType }
     */
    public TicketingInfoType createTicketingInfoType() {
        return new TicketingInfoType();
    }

    /**
     * Create an instance of {@link LocationType }
     */
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link PkgFlightSegmentBaseType.DepartureAirport }
     */
    public PkgFlightSegmentBaseType.DepartureAirport createPkgFlightSegmentBaseTypeDepartureAirport() {
        return new PkgFlightSegmentBaseType.DepartureAirport();
    }

    /**
     * Create an instance of {@link PkgFlightSegmentBaseType.ArrivalAirport }
     */
    public PkgFlightSegmentBaseType.ArrivalAirport createPkgFlightSegmentBaseTypeArrivalAirport() {
        return new PkgFlightSegmentBaseType.ArrivalAirport();
    }

    /**
     * Create an instance of {@link ContactPersonType.Telephone }
     */
    public ContactPersonType.Telephone createContactPersonTypeTelephone() {
        return new ContactPersonType.Telephone();
    }

    /**
     * Create an instance of {@link CustomerCountsType.CustomerCount }
     */
    public CustomerCountsType.CustomerCount createCustomerCountsTypeCustomerCount() {
        return new CustomerCountsType.CustomerCount();
    }

    /**
     * Create an instance of {@link AddressType.StreetNmbr }
     */
    public AddressType.StreetNmbr createAddressTypeStreetNmbr() {
        return new AddressType.StreetNmbr();
    }

    /**
     * Create an instance of {@link AddressType.BldgRoom }
     */
    public AddressType.BldgRoom createAddressTypeBldgRoom() {
        return new AddressType.BldgRoom();
    }

    /**
     * Create an instance of {@link DocumentType.AdditionalPersonNames }
     */
    public DocumentType.AdditionalPersonNames createDocumentTypeAdditionalPersonNames() {
        return new DocumentType.AdditionalPersonNames();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.CostingItems }
     */
    public PkgInvoiceDetail.CostingItems createPkgInvoiceDetailCostingItems() {
        return new PkgInvoiceDetail.CostingItems();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.GrossAmount }
     */
    public PkgInvoiceDetail.GrossAmount createPkgInvoiceDetailGrossAmount() {
        return new PkgInvoiceDetail.GrossAmount();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.DepositAmount }
     */
    public PkgInvoiceDetail.DepositAmount createPkgInvoiceDetailDepositAmount() {
        return new PkgInvoiceDetail.DepositAmount();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.DiscountAmount }
     */
    public PkgInvoiceDetail.DiscountAmount createPkgInvoiceDetailDiscountAmount() {
        return new PkgInvoiceDetail.DiscountAmount();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.AgentCommission }
     */
    public PkgInvoiceDetail.AgentCommission createPkgInvoiceDetailAgentCommission() {
        return new PkgInvoiceDetail.AgentCommission();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.NetAmount }
     */
    public PkgInvoiceDetail.NetAmount createPkgInvoiceDetailNetAmount() {
        return new PkgInvoiceDetail.NetAmount();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.BalanceDueAmount }
     */
    public PkgInvoiceDetail.BalanceDueAmount createPkgInvoiceDetailBalanceDueAmount() {
        return new PkgInvoiceDetail.BalanceDueAmount();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.AmountReceived }
     */
    public PkgInvoiceDetail.AmountReceived createPkgInvoiceDetailAmountReceived() {
        return new PkgInvoiceDetail.AmountReceived();
    }

    /**
     * Create an instance of {@link PkgInvoiceDetail.DepositAmounts.DepositAmount }
     */
    public PkgInvoiceDetail.DepositAmounts.DepositAmount createPkgInvoiceDetailDepositAmountsDepositAmount() {
        return new PkgInvoiceDetail.DepositAmounts.DepositAmount();
    }

    /**
     * Create an instance of {@link ItineraryItemResponseType.RentalCar }
     */
    public ItineraryItemResponseType.RentalCar createItineraryItemResponseTypeRentalCar() {
        return new ItineraryItemResponseType.RentalCar();
    }

    /**
     * Create an instance of {@link VehicleRentalCoreType.PickUpLocation }
     */
    public VehicleRentalCoreType.PickUpLocation createVehicleRentalCoreTypePickUpLocation() {
        return new VehicleRentalCoreType.PickUpLocation();
    }

    /**
     * Create an instance of {@link VehicleRentalCoreType.ReturnLocation }
     */
    public VehicleRentalCoreType.ReturnLocation createVehicleRentalCoreTypeReturnLocation() {
        return new VehicleRentalCoreType.ReturnLocation();
    }

    /**
     * Create an instance of {@link ItineraryItemResponseType.Accommodation.AccommodationClass }
     */
    public ItineraryItemResponseType.Accommodation.AccommodationClass createItineraryItemResponseTypeAccommodationAccommodationClass() {
        return new ItineraryItemResponseType.Accommodation.AccommodationClass();
    }

    /**
     * Create an instance of {@link ItineraryItemResponseType.Accommodation.MealPlans }
     */
    public ItineraryItemResponseType.Accommodation.MealPlans createItineraryItemResponseTypeAccommodationMealPlans() {
        return new ItineraryItemResponseType.Accommodation.MealPlans();
    }

    /**
     * Create an instance of {@link RoomProfileType.PassengerRPHs }
     */
    public RoomProfileType.PassengerRPHs createRoomProfileTypePassengerRPHs() {
        return new RoomProfileType.PassengerRPHs();
    }

    /**
     * Create an instance of {@link ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile.Prices.Price }
     */
    public ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile.Prices.Price createItineraryItemResponseTypeAccommodationRoomProfilesRoomProfilePricesPrice() {
        return new ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile.Prices.Price();
    }

    /**
     * Create an instance of {@link CabinAvailType.BaggageAllowance }
     */
    public CabinAvailType.BaggageAllowance createCabinAvailTypeBaggageAllowance() {
        return new CabinAvailType.BaggageAllowance();
    }

    /**
     * Create an instance of {@link SeatRequestType.TPAExtensions.SeatInfo }
     */
    public SeatRequestType.TPAExtensions.SeatInfo createSeatRequestTypeTPAExtensionsSeatInfo() {
        return new SeatRequestType.TPAExtensions.SeatInfo();
    }

    /**
     * Create an instance of {@link PackageResponseType.DateRange }
     */
    public PackageResponseType.DateRange createPackageResponseTypeDateRange() {
        return new PackageResponseType.DateRange();
    }

    /**
     * Create an instance of {@link PackageResponseType.ItineraryItems }
     */
    public PackageResponseType.ItineraryItems createPackageResponseTypeItineraryItems() {
        return new PackageResponseType.ItineraryItems();
    }

    /**
     * Create an instance of {@link PackageResponseType.Extras }
     */
    public PackageResponseType.Extras createPackageResponseTypeExtras() {
        return new PackageResponseType.Extras();
    }

    /**
     * Create an instance of {@link PackageResponseType.SeatRequests }
     */
    public PackageResponseType.SeatRequests createPackageResponseTypeSeatRequests() {
        return new PackageResponseType.SeatRequests();
    }

    /**
     * Create an instance of {@link PackageResponseType.Cautions }
     */
    public PackageResponseType.Cautions createPackageResponseTypeCautions() {
        return new PackageResponseType.Cautions();
    }

    /**
     * Create an instance of {@link PkgPassengerListItem.SpecialNeed }
     */
    public PkgPassengerListItem.SpecialNeed createPkgPassengerListItemSpecialNeed() {
        return new PkgPassengerListItem.SpecialNeed();
    }

    /**
     * Create an instance of {@link FlightSegmentBaseType.DepartureAirport }
     */
    public FlightSegmentBaseType.DepartureAirport createFlightSegmentBaseTypeDepartureAirport() {
        return new FlightSegmentBaseType.DepartureAirport();
    }

    /**
     * Create an instance of {@link FlightSegmentBaseType.ArrivalAirport }
     */
    public FlightSegmentBaseType.ArrivalAirport createFlightSegmentBaseTypeArrivalAirport() {
        return new FlightSegmentBaseType.ArrivalAirport();
    }

    /**
     * Create an instance of {@link OperationScheduleType.OperationTimes.OperationTime }
     */
    public OperationScheduleType.OperationTimes.OperationTime createOperationScheduleTypeOperationTimesOperationTime() {
        return new OperationScheduleType.OperationTimes.OperationTime();
    }

    /**
     * Create an instance of {@link ItineraryItemRequestType.RentalCar }
     */
    public ItineraryItemRequestType.RentalCar createItineraryItemRequestTypeRentalCar() {
        return new ItineraryItemRequestType.RentalCar();
    }

    /**
     * Create an instance of {@link DateTimeSpanType.StartDateWindow }
     */
    public DateTimeSpanType.StartDateWindow createDateTimeSpanTypeStartDateWindow() {
        return new DateTimeSpanType.StartDateWindow();
    }

    /**
     * Create an instance of {@link DateTimeSpanType.EndDateWindow }
     */
    public DateTimeSpanType.EndDateWindow createDateTimeSpanTypeEndDateWindow() {
        return new DateTimeSpanType.EndDateWindow();
    }

    /**
     * Create an instance of {@link GuestCountType.GuestCount }
     */
    public GuestCountType.GuestCount createGuestCountTypeGuestCount() {
        return new GuestCountType.GuestCount();
    }

    /**
     * Create an instance of {@link MealPlanType.PassengerRPHs }
     */
    public MealPlanType.PassengerRPHs createMealPlanTypePassengerRPHs() {
        return new MealPlanType.PassengerRPHs();
    }

    /**
     * Create an instance of {@link MealPlanType.Prices.Price }
     */
    public MealPlanType.Prices.Price createMealPlanTypePricesPrice() {
        return new MealPlanType.Prices.Price();
    }

    /**
     * Create an instance of {@link SourceType.RequestorID }
     */
    public SourceType.RequestorID createSourceTypeRequestorID() {
        return new SourceType.RequestorID();
    }

    /**
     * Create an instance of {@link SourceType.Position }
     */
    public SourceType.Position createSourceTypePosition() {
        return new SourceType.Position();
    }

    /**
     * Create an instance of {@link SourceType.BookingChannel }
     */
    public SourceType.BookingChannel createSourceTypeBookingChannel() {
        return new SourceType.BookingChannel();
    }

    /**
     * Create an instance of {@link PaymentFormType.Voucher }
     */
    public PaymentFormType.Voucher createPaymentFormTypeVoucher() {
        return new PaymentFormType.Voucher();
    }

    /**
     * Create an instance of {@link PaymentFormType.MiscChargeOrder }
     */
    public PaymentFormType.MiscChargeOrder createPaymentFormTypeMiscChargeOrder() {
        return new PaymentFormType.MiscChargeOrder();
    }

    /**
     * Create an instance of {@link PaymentFormType.Cash }
     */
    public PaymentFormType.Cash createPaymentFormTypeCash() {
        return new PaymentFormType.Cash();
    }

    /**
     * Create an instance of {@link PaymentDetailType.PaymentAmount }
     */
    public PaymentDetailType.PaymentAmount createPaymentDetailTypePaymentAmount() {
        return new PaymentDetailType.PaymentAmount();
    }

    /**
     * Create an instance of {@link PaymentFormType.LoyaltyRedemption.LoyaltyCertificate }
     */
    public PaymentFormType.LoyaltyRedemption.LoyaltyCertificate createPaymentFormTypeLoyaltyRedemptionLoyaltyCertificate() {
        return new PaymentFormType.LoyaltyRedemption.LoyaltyCertificate();
    }

    /**
     * Create an instance of {@link AccommodationInfoType.Resort }
     */
    public AccommodationInfoType.Resort createAccommodationInfoTypeResort() {
        return new AccommodationInfoType.Resort();
    }

    /**
     * Create an instance of {@link AccommodationInfoType.AccommodationClass }
     */
    public AccommodationInfoType.AccommodationClass createAccommodationInfoTypeAccommodationClass() {
        return new AccommodationInfoType.AccommodationClass();
    }

    /**
     * Create an instance of {@link FacilityChoicesType.AvailableRooms }
     */
    public FacilityChoicesType.AvailableRooms createFacilityChoicesTypeAvailableRooms() {
        return new FacilityChoicesType.AvailableRooms();
    }

    /**
     * Create an instance of {@link FacilityChoicesType.AvailableMealPlans }
     */
    public FacilityChoicesType.AvailableMealPlans createFacilityChoicesTypeAvailableMealPlans() {
        return new FacilityChoicesType.AvailableMealPlans();
    }

    /**
     * Create an instance of {@link FacilityChoicesType.RoomPrices }
     */
    public FacilityChoicesType.RoomPrices createFacilityChoicesTypeRoomPrices() {
        return new FacilityChoicesType.RoomPrices();
    }

    /**
     * Create an instance of {@link ParagraphType.ListItem }
     */
    public ParagraphType.ListItem createParagraphTypeListItem() {
        return new ParagraphType.ListItem();
    }

    /**
     * Create an instance of {@link DirectBillType.CompanyName }
     */
    public DirectBillType.CompanyName createDirectBillTypeCompanyName() {
        return new DirectBillType.CompanyName();
    }

    /**
     * Create an instance of {@link RoomPriceType.ProfilePrice }
     */
    public RoomPriceType.ProfilePrice createRoomPriceTypeProfilePrice() {
        return new RoomPriceType.ProfilePrice();
    }

    /**
     * Create an instance of {@link AccommodationSegmentRequestType.RoomProfiles }
     */
    public AccommodationSegmentRequestType.RoomProfiles createAccommodationSegmentRequestTypeRoomProfiles() {
        return new AccommodationSegmentRequestType.RoomProfiles();
    }

    /**
     * Create an instance of {@link AccommodationSegmentRequestType.MealPlans }
     */
    public AccommodationSegmentRequestType.MealPlans createAccommodationSegmentRequestTypeMealPlans() {
        return new AccommodationSegmentRequestType.MealPlans();
    }

    /**
     * Create an instance of {@link ExtrasCoreType.SubCategory }
     */
    public ExtrasCoreType.SubCategory createExtrasCoreTypeSubCategory() {
        return new ExtrasCoreType.SubCategory();
    }

    /**
     * Create an instance of {@link ExtrasInfoType.Criteria }
     */
    public ExtrasInfoType.Criteria createExtrasInfoTypeCriteria() {
        return new ExtrasInfoType.Criteria();
    }

    /**
     * Create an instance of {@link ExtrasInfoType.Periods }
     */
    public ExtrasInfoType.Periods createExtrasInfoTypePeriods() {
        return new ExtrasInfoType.Periods();
    }

    /**
     * Create an instance of {@link ExtrasInfoType.AdditionalInfoPrompt }
     */
    public ExtrasInfoType.AdditionalInfoPrompt createExtrasInfoTypeAdditionalInfoPrompt() {
        return new ExtrasInfoType.AdditionalInfoPrompt();
    }

    /**
     * Create an instance of {@link ExtrasInfoType.ParentExtras }
     */
    public ExtrasInfoType.ParentExtras createExtrasInfoTypeParentExtras() {
        return new ExtrasInfoType.ParentExtras();
    }

    /**
     * Create an instance of {@link ExtrasInfoType.ExtraLocationInfo }
     */
    public ExtrasInfoType.ExtraLocationInfo createExtrasInfoTypeExtraLocationInfo() {
        return new ExtrasInfoType.ExtraLocationInfo();
    }

    /**
     * Create an instance of {@link PkgAirSegmentType.AvailableSeats }
     */
    public PkgAirSegmentType.AvailableSeats createPkgAirSegmentTypeAvailableSeats() {
        return new PkgAirSegmentType.AvailableSeats();
    }

    /**
     * Create an instance of {@link PkgAirSegmentType.Passengers }
     */
    public PkgAirSegmentType.Passengers createPkgAirSegmentTypePassengers() {
        return new PkgAirSegmentType.Passengers();
    }

    /**
     * Create an instance of {@link PaymentCardType.CardIssuerName }
     */
    public PaymentCardType.CardIssuerName createPaymentCardTypeCardIssuerName() {
        return new PaymentCardType.CardIssuerName();
    }

    /**
     * Create an instance of {@link PackageType.DateRange }
     */
    public PackageType.DateRange createPackageTypeDateRange() {
        return new PackageType.DateRange();
    }

    /**
     * Create an instance of {@link PackageType.ItineraryItems }
     */
    public PackageType.ItineraryItems createPackageTypeItineraryItems() {
        return new PackageType.ItineraryItems();
    }

    /**
     * Create an instance of {@link PackageType.Extras }
     */
    public PackageType.Extras createPackageTypeExtras() {
        return new PackageType.Extras();
    }

    /**
     * Create an instance of {@link PackageType.SeatRequests }
     */
    public PackageType.SeatRequests createPackageTypeSeatRequests() {
        return new PackageType.SeatRequests();
    }

    /**
     * Create an instance of {@link CostingItemType.UnitCost }
     */
    public CostingItemType.UnitCost createCostingItemTypeUnitCost() {
        return new CostingItemType.UnitCost();
    }

    /**
     * Create an instance of {@link CostingItemType.UnitPrice }
     */
    public CostingItemType.UnitPrice createCostingItemTypeUnitPrice() {
        return new CostingItemType.UnitPrice();
    }

    /**
     * Create an instance of {@link CostingItemType.ExtendedCost }
     */
    public CostingItemType.ExtendedCost createCostingItemTypeExtendedCost() {
        return new CostingItemType.ExtendedCost();
    }

    /**
     * Create an instance of {@link CostingItemType.ExtendedPrice }
     */
    public CostingItemType.ExtendedPrice createCostingItemTypeExtendedPrice() {
        return new CostingItemType.ExtendedPrice();
    }

    /**
     * Create an instance of {@link CostingItemType.Commission }
     */
    public CostingItemType.Commission createCostingItemTypeCommission() {
        return new CostingItemType.Commission();
    }

    /**
     * Create an instance of {@link OTAPkgCostRS.Package.AcceptedPaymtForms.AcceptedPaymtForm }
     */
    public OTAPkgCostRS.Package.AcceptedPaymtForms.AcceptedPaymtForm createOTAPkgCostRSPackageAcceptedPaymtFormsAcceptedPaymtForm() {
        return new OTAPkgCostRS.Package.AcceptedPaymtForms.AcceptedPaymtForm();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPAExtensionsType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "TPA_Extensions")
    public JAXBElement<TPAExtensionsType> createTPAExtensions(TPAExtensionsType value) {
        return new JAXBElement<>(_TPAExtensions_QNAME, TPAExtensionsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "Image", scope = ParagraphType.class)
    public JAXBElement<String> createParagraphTypeImage(String value) {
        return new JAXBElement<>(_ParagraphTypeImage_QNAME, String.class, ParagraphType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "URL", scope = ParagraphType.class)
    public JAXBElement<String> createParagraphTypeURL(String value) {
        return new JAXBElement<>(_ParagraphTypeURL_QNAME, String.class, ParagraphType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FormattedTextTextType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "Text", scope = ParagraphType.class)
    public JAXBElement<FormattedTextTextType> createParagraphTypeText(FormattedTextTextType value) {
        return new JAXBElement<>(_ParagraphTypeText_QNAME, FormattedTextTextType.class, ParagraphType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParagraphType.ListItem }{@code >}}
     */
    @XmlElementDecl(namespace = "http://www.opentravel.org/OTA/2003/05", name = "ListItem", scope = ParagraphType.class)
    public JAXBElement<ParagraphType.ListItem> createParagraphTypeListItem(ParagraphType.ListItem value) {
        return new JAXBElement<>(_ParagraphTypeListItem_QNAME, ParagraphType.ListItem.class, ParagraphType.class, value);
    }

}
