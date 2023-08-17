// Timoor Mujeeb - s1912918
package com.mujeeb_taimoor_s1912918.currencyapp.utils;

import com.mujeeb_taimoor_s1912918.currencyapp.R;

import java.util.Arrays;
import java.util.List;

public class CurrencyHelper {
    public static final CurrencyHelper[] CURRENCIES = {
            new CurrencyHelper("EUR", R.drawable.flag_eur),
            new CurrencyHelper("USD", R.drawable.flag_usd),
            new CurrencyHelper("GBP", R.drawable.flag_gbp),
            new CurrencyHelper("CZK", R.drawable.flag_czk),
            new CurrencyHelper("TRY", R.drawable.flag_try),
            new CurrencyHelper("AED", R.drawable.flag_aed),
            new CurrencyHelper("AFN", R.drawable.flag_afn),
            new CurrencyHelper("ARS", R.drawable.flag_ars),
            new CurrencyHelper("AUD", R.drawable.flag_aud),
            new CurrencyHelper("BBD", R.drawable.flag_bbd),
            new CurrencyHelper("BDT", R.drawable.flag_bdt),
            new CurrencyHelper("BGN", R.drawable.flag_bgn),
            new CurrencyHelper("BHD", R.drawable.flag_bhd),
            new CurrencyHelper("BMD", R.drawable.flag_bmd),
            new CurrencyHelper("BND", R.drawable.flag_bnd),
            new CurrencyHelper("BOB", R.drawable.flag_bob),
            new CurrencyHelper("BRL", R.drawable.flag_brl),
            new CurrencyHelper("BTN", R.drawable.flag_btn),
            new CurrencyHelper("BZD", R.drawable.flag_bzd),
            new CurrencyHelper("CAD", R.drawable.flag_cad),
            new CurrencyHelper("CHF", R.drawable.flag_chf),
            new CurrencyHelper("CLP", R.drawable.flag_clp),
            new CurrencyHelper("CNY", R.drawable.flag_cny),
            new CurrencyHelper("COP", R.drawable.flag_cop),
            new CurrencyHelper("CRC", R.drawable.flag_crc),
            new CurrencyHelper("DKK", R.drawable.flag_dkk),
            new CurrencyHelper("DOP", R.drawable.flag_dop),
            new CurrencyHelper("EGP", R.drawable.flag_egp),
            new CurrencyHelper("ETB", R.drawable.flag_etb),
            new CurrencyHelper("GEL", R.drawable.flag_gel),
            new CurrencyHelper("GHS", R.drawable.flag_ghs),
            new CurrencyHelper("GMD", R.drawable.flag_gmd),
            new CurrencyHelper("GYD", R.drawable.flag_gyd),
            new CurrencyHelper("HKD", R.drawable.flag_hkd),
            new CurrencyHelper("HRK", R.drawable.flag_hrk),
            new CurrencyHelper("HUF", R.drawable.flag_huf),
            new CurrencyHelper("IDR", R.drawable.flag_idr),
            new CurrencyHelper("ILS", R.drawable.flag_ils),
            new CurrencyHelper("INR", R.drawable.flag_inr),
            new CurrencyHelper("ISK", R.drawable.flag_isk),
            new CurrencyHelper("JMD", R.drawable.flag_jmd),
            new CurrencyHelper("JPY", R.drawable.flag_jpy),
            new CurrencyHelper("KES", R.drawable.flag_kes),
            new CurrencyHelper("KRW", R.drawable.flag_krw),
            new CurrencyHelper("KWD", R.drawable.flag_kwd),
            new CurrencyHelper("KYD", R.drawable.flag_kyd),
            new CurrencyHelper("KZT", R.drawable.flag_kzt),
            new CurrencyHelper("LAK", R.drawable.flag_lak),
            new CurrencyHelper("LKR", R.drawable.flag_lkr),
            new CurrencyHelper("LRD", R.drawable.flag_lrd),
            new CurrencyHelper("LTL", R.drawable.flag_ltu),
            new CurrencyHelper("MAD", R.drawable.flag_mad),
            new CurrencyHelper("MDL", R.drawable.flag_mdl),
            new CurrencyHelper("MKD", R.drawable.flag_mkd),
            new CurrencyHelper("MNT", R.drawable.flag_mnt),
            new CurrencyHelper("MUR", R.drawable.flag_mur),
            new CurrencyHelper("MWK", R.drawable.flag_mwk),
            new CurrencyHelper("MXN", R.drawable.flag_mxn),
            new CurrencyHelper("MYR", R.drawable.flag_myr),
            new CurrencyHelper("MZN", R.drawable.flag_mzn),
            new CurrencyHelper("NAD", R.drawable.flag_nad),
            new CurrencyHelper("NGN", R.drawable.flag_ngn),
            new CurrencyHelper("NIO", R.drawable.flag_nio),
            new CurrencyHelper("NOK", R.drawable.flag_nok),
            new CurrencyHelper("NPR", R.drawable.flag_npr),
            new CurrencyHelper("NZD", R.drawable.flag_nzd),
            new CurrencyHelper("OMR", R.drawable.flag_omr),
            new CurrencyHelper("PEN", R.drawable.flag_pen),
            new CurrencyHelper("PGK", R.drawable.flag_pgk),
            new CurrencyHelper("PHP", R.drawable.flag_php),
            new CurrencyHelper("PKR", R.drawable.flag_pkr),
            new CurrencyHelper("PLN", R.drawable.flag_pln),
            new CurrencyHelper("PYG", R.drawable.flag_pyg),
            new CurrencyHelper("QAR", R.drawable.flag_qar),
            new CurrencyHelper("RON", R.drawable.flag_ron),
            new CurrencyHelper("RSD", R.drawable.flag_rsd),
            new CurrencyHelper("RUB", R.drawable.flag_rub),
            new CurrencyHelper("SAR", R.drawable.flag_sar),
            new CurrencyHelper("SEK", R.drawable.flag_sek),
            new CurrencyHelper("SGD", R.drawable.flag_sgd),
            new CurrencyHelper("SOS", R.drawable.flag_sos),
            new CurrencyHelper("SRD", R.drawable.flag_srd),
            new CurrencyHelper("THB", R.drawable.flag_thb),
            new CurrencyHelper("TTD", R.drawable.flag_ttd),
            new CurrencyHelper("TWD", R.drawable.flag_twd),
            new CurrencyHelper("TZS", R.drawable.flag_tzs),
            new CurrencyHelper("UAH", R.drawable.flag_uah),
            new CurrencyHelper("UGX", R.drawable.flag_ugx),
            new CurrencyHelper("UYU", R.drawable.flag_uyu),
            new CurrencyHelper("VEF", R.drawable.flag_vef),
            new CurrencyHelper("VND", R.drawable.flag_vnd),
            new CurrencyHelper("YER", R.drawable.flag_yer),
            new CurrencyHelper("ZAR", R.drawable.flag_zar),
            new CurrencyHelper("GTQ", R.drawable.flag_gtq),

            new CurrencyHelper("ANG", R.drawable.flag_ang),
            new CurrencyHelper("BWP", R.drawable.flag_bwp),
            new CurrencyHelper("DZD", R.drawable.flag_dzd),
            new CurrencyHelper("FJD", R.drawable.flag_fjd),
            new CurrencyHelper("EEK", R.drawable.flag_eek),
            new CurrencyHelper("HNL", R.drawable.flag_hnl),
            new CurrencyHelper("JOD", R.drawable.flag_jod),
            new CurrencyHelper("LBP", R.drawable.flag_lbp),
            new CurrencyHelper("LVL", R.drawable.flag_lvl),
            new CurrencyHelper("MVR", R.drawable.flag_mvr),
            new CurrencyHelper("SCR", R.drawable.flag_scr),
            new CurrencyHelper("SKK", R.drawable.flag_skk),
            new CurrencyHelper("SVC", R.drawable.flag_svc),
            new CurrencyHelper("TND", R.drawable.flag_tnd),
            new CurrencyHelper("UZS", R.drawable.flag_uzs),
            new CurrencyHelper("XOF", R.drawable.flag_xof),
            new CurrencyHelper("ZMK", R.drawable.flag_zmk),
            new CurrencyHelper("IQD", R.drawable.flag_iqd),
            new CurrencyHelper("ALL", R.drawable.flag_all),
            new CurrencyHelper("BSD", R.drawable.flag_bsd),
            new CurrencyHelper("BIF", R.drawable.flag_bif),
            new CurrencyHelper("KHR", R.drawable.flag_khr),
            new CurrencyHelper("CVE", R.drawable.flag_cve),
            new CurrencyHelper("BEAC", R.drawable.flag_beac),
            new CurrencyHelper("KMF", R.drawable.flag_kmf),
            new CurrencyHelper("SLL", R.drawable.flag_sll),
            new CurrencyHelper("CUP", R.drawable.flag_cup),
            new CurrencyHelper("DJF", R.drawable.flag_djf),
            new CurrencyHelper("XCD", R.drawable.flag_xcd),
            new CurrencyHelper("GNF", R.drawable.flag_gnf),
            new CurrencyHelper("HTG", R.drawable.flag_htg),
            new CurrencyHelper("IRR", R.drawable.flag_irr),
            new CurrencyHelper("LSL", R.drawable.flag_lsl),
            new CurrencyHelper("LYD", R.drawable.flag_lyd),
            new CurrencyHelper("MOP", R.drawable.flag_mop),
            new CurrencyHelper("MRO", R.drawable.flag_mro),
            new CurrencyHelper("MMK", R.drawable.flag_mmk),
            new CurrencyHelper("KPW", R.drawable.flag_kpw),
            new CurrencyHelper("RWF", R.drawable.flag_rwf),
            new CurrencyHelper("WST", R.drawable.flag_wst),
            new CurrencyHelper("SBD", R.drawable.flag_sbd),
            new CurrencyHelper("SDG", R.drawable.flag_sdg),
            new CurrencyHelper("SZL", R.drawable.flag_szl),
            new CurrencyHelper("SYP", R.drawable.flag_syp),
            new CurrencyHelper("TOP", R.drawable.flag_top),
            new CurrencyHelper("VUV", R.drawable.flag_vuv),
            new CurrencyHelper("KGS", R.drawable.flag_kgs),
            new CurrencyHelper("BYN", R.drawable.flag_byn),
            new CurrencyHelper("AOA", R.drawable.flag_aoa),
            new CurrencyHelper("AMD", R.drawable.flag_amd),
            new CurrencyHelper("AZN", R.drawable.flag_azn),
            new CurrencyHelper("BAM", R.drawable.flag_bam),
            new CurrencyHelper("CDF", R.drawable.flag_cdf),
            new CurrencyHelper("MGA", R.drawable.flag_mga),
            new CurrencyHelper("TJS", R.drawable.flag_tjs),
            new CurrencyHelper("TMT", R.drawable.flag_tmt),
            new CurrencyHelper("ZMW", R.drawable.flag_zmw),
            new CurrencyHelper("AWG", R.drawable.flag_awg),
            new CurrencyHelper("BYR", R.drawable.flag_byr),
            new CurrencyHelper("FKP", R.drawable.flag_fkp),
            new CurrencyHelper("XPF", R.drawable.flag_xpf),
            new CurrencyHelper("PAB", R.drawable.flag_pab),
            new CurrencyHelper("STD", R.drawable.flag_std),
            new CurrencyHelper("SHP", R.drawable.flag_shp),
            new CurrencyHelper("ZWD", R.drawable.flag_zwd),
            new CurrencyHelper("BTC", R.drawable.flag_btc),
            new CurrencyHelper("ERN", R.drawable.flag_ern),
    };

    private String code;
    private int flag = -1;

    public CurrencyHelper(String code, int flag) {
        this.code = code;
        this.flag = flag;
    }

    public String getCode() {
        return code;
    }

    public int getFlag() {
        return flag;
    }

    private static List<CurrencyHelper> allCurrenciesList;

    public static List<CurrencyHelper> getAllCurrencies() {
        if (allCurrenciesList == null) {
            allCurrenciesList = Arrays.asList(CURRENCIES);
        }
        return allCurrenciesList;
    }

    public static CurrencyHelper getCurrencyByISO(String currencyIsoCode) {
        for (CurrencyHelper c : CURRENCIES) {
            if (currencyIsoCode.equals(c.getCode())) {
                return c;
            }
        }
        return null;
    }


}
