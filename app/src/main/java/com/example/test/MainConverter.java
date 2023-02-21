package com.example.test;

import java.util.ArrayList;
import java.util.List;
public class MainConverter {

    public List<CardInfoItemModel> convert(Card card) {
        List<CardInfoItemModel> listCardInfo = new ArrayList<>();
        if (infoIsEmpty(card.getScheme())){
        MainCardInfo mainCardInfoScheme = new MainCardInfo("Scheme:", card.getScheme());
        listCardInfo.add(mainCardInfoScheme);}
        if (infoIsEmpty(card.getType())){
        MainCardInfo mainCardInfoType = new MainCardInfo("Type:", card.getType());
        listCardInfo.add(mainCardInfoType);}
        if (infoIsEmpty(card.getBrand())){
        MainCardInfo mainCardInfoBrand = new MainCardInfo("Brand:", card.getBrand());
        listCardInfo.add(mainCardInfoBrand);}
        MainCardInfo mainCardInfoPrepaid = new MainCardInfo("Prepaid:", booleanToString(card.isPrepaid(), "Yes", "No"));
        listCardInfo.add(mainCardInfoPrepaid);
        if (infoIsEmpty(card.getCountry().getCurrency())){
            MainCardInfo mainCardInfoBrand = new MainCardInfo("Currency:", card.getCountry().getCurrency());
            listCardInfo.add(mainCardInfoBrand);}
        if (numberInfo(card.getNumber()) != null){
        MainCardInfo mainCardInfoNumber = new MainCardInfo("Number:", numberInfo(card.getNumber()));
        listCardInfo.add(mainCardInfoNumber);}
        CountryInfoItemModel countryInfoItemModel = new CountryInfoItemModel(
                "Country name:",
                "Coordinate:",
                card.getCountry().getAlpha2() + " " + card.getCountry().getName(),
                card.getCountry().getLatitude() + "/" + card.getCountry().getLongitude());
        listCardInfo.add(countryInfoItemModel);
        if (card.getBank().getName() != null || card.getBank().getUrl() != null || card.getBank().getPhone() != null){
        BankInfoItemModel bankInfoItemModel = new BankInfoItemModel(
                "Bank info:",
                card.getBank().getName(),
                card.getBank().getUrl(),
                card.getBank().getPhone()
        );
        listCardInfo.add(bankInfoItemModel);}
        return listCardInfo;

    }

    private String numberInfo(Number number) {
        String numberCardInfo = null;
        if (number.getLength() != null && number.isLuhn() != null) {
            numberCardInfo = "Length: " + number.getLength() + "\n" + "Luhn: " + booleanToString(number.isLuhn(), "Yes", "No");
        } else if (number.getLength() != null) {
            numberCardInfo = "Length: " + number.getLength();
        } else if (number.isLuhn() != null) {
            numberCardInfo = "Luhn: " + booleanToString(number.isLuhn(), "Yes", "No");
        }
        return numberCardInfo;
    }

    private String booleanToString(boolean predicate, String trueString, String falseString) {
        String result;
            if (predicate) {
                result = trueString;
            }
            else {
                result = falseString;
            }
        return result;
    }

    private boolean infoIsEmpty(String info) {
        boolean infoIsNotEmpty = false;
        if(info != null && !info.isEmpty()) {
            infoIsNotEmpty = true;
            }
        return infoIsNotEmpty;
    }
}
