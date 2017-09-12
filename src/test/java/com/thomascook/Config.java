package com.thomascook;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigProperties {
    private static final String SYS_PROPERTY_ENV = "env";
    private static final String CONFIG_PROPERTIES_JSON_PATH = "src/test/resources/config_properties.json";
    private static final String DEFAULT_ENVIRONMENT = "staging";
    private static final File CREDENTIALS_CONFIG = new File("src/test/resources/credentials.properties");

    private static String solrNl;
    private static String solrBe;
    private static String solrUk;
    private static String solrDe;
    private static String nurvisBe;
    private static String nurvisNl;
    private static String nurvisDe;
    private static String sfwUrl;
    private static String sfwRequestBody;
    private static Long customerRetrieveTimeout;
    private static String msdBaseUrl;
    private static String tosca;
    private static String msdLogin;
    private static String msdPassword;

    private static ConfigProperties _config = null;

    public String getSolrNl() {
        return solrNl;
    }

    public String getSolrBe() {
        return solrBe;
    }

    public String getSolrUk() {
        return solrUk;
    }

    public String getSolrDe() {
        return solrDe;
    }

    public String getNurvisBe() {
        return nurvisBe;
    }

    public String getNurvisNl() {
        return nurvisNl;
    }

    public String getNurvisDe() {
        return nurvisDe;
    }

    public String getSfwUrl() {
        return sfwUrl;
    }

    public String getSfwRequestBody() {
        return sfwRequestBody;
    }

    public Long getCustomerRetrieveTimeout() {
        return customerRetrieveTimeout;
    }

    public String getMsdBaseUrl() {
        return msdBaseUrl;
    }

    public String getTosca() {
        return tosca;
    }

    public String getMsdLogin() {
        return msdLogin;
    }

    public String getMsdPassword() {
        return msdPassword;
    }

//    public static ConfigProperties getConfig() {
//        return new ConfigProperties() {
//            @Override
//            public String getSolrNl() {
//                return super.getSolrNl();
//            }
//
//            @Override
//            public String getSolrBe() {
//                return super.getSolrBe();
//            }
//
//            @Override
//            public String getSolrUk() {
//                return super.getSolrUk();
//            }
//
//            @Override
//            public String getSolrDe() {
//                return super.getSolrDe();
//            }
//
//            @Override
//            public String getNurvisBe() {
//                return super.getNurvisBe();
//            }
//
//            @Override
//            public String getNurvisNl() {
//                return super.getNurvisNl();
//            }
//
//            @Override
//            public String getNurvisDe() {
//                return super.getNurvisDe();
//            }
//
//            @Override
//            public String getSfwUrl() {
//                return super.getSfwUrl();
//            }
//
//            @Override
//            public String getSfwRequestBody() {
//                return super.getSfwRequestBody();
//            }
//
//            @Override
//            public Long getCustomerRetrieveTimeout() {
//                return super.getCustomerRetrieveTimeout();
//            }
//
//            @Override
//            public String getMsdBaseUrl() {
//                return super.getMsdBaseUrl();
//            }
//
//            @Override
//            public String getTosca() {
//                return super.getTosca();
//            }
//
//            @Override
//            public String getMsdLogin() {
//                return super.getMsdLogin();
//            }
//
//            @Override
//            public String getMsdPassword() {
//                return super.getMsdPassword();
//            }
//
//            @Override
//            public String toString() {
//                return super.toString();
//            }
//        };
//    }

    private ConfigProperties(){initConfig();}

    public static ConfigProperties getInstance() {
        if (_config == null) {
            _config = new ConfigProperties();
        }
        return _config;
    }

    private static void initConfig() {
        JSONObject environmentalConfig, solr, nurvis, sfw;
        Object obj;

        try {
            obj = new JSONObject(new String(Files.readAllBytes(Paths.get(CONFIG_PROPERTIES_JSON_PATH))));
            environmentalConfig = (JSONObject) ((JSONObject) obj).get(System.getProperty(SYS_PROPERTY_ENV, DEFAULT_ENVIRONMENT));

            solr = environmentalConfig.getJSONObject("solr");
            solrNl = solr.getString("nl");
            solrBe = solr.getString("be");
            solrUk = solr.getString("uk");
            solrDe = solr.getString("de");

            nurvis = environmentalConfig.getJSONObject("nurvis");
            nurvisBe = nurvis.getString("be");
            nurvisNl = nurvis.getString("nl");
            nurvisDe = nurvis.getString("de");

            sfw = environmentalConfig.getJSONObject("sfw");
            sfwUrl = sfw.getString("url");
            sfwRequestBody = sfw.getString("request");

            customerRetrieveTimeout = environmentalConfig.getLong("customerRetrieveTimeoutMin");
            msdBaseUrl = environmentalConfig.getJSONObject("msd").getString("baseUrl");
            tosca = environmentalConfig.getString("tosca");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream is;
            Properties properties = new Properties();

            is = new FileInputStream(CREDENTIALS_CONFIG);
            properties.load(is);
            msdLogin = properties.getProperty("msd.user.name");
            msdPassword = properties.getProperty("msd.user.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ConfigProperties{" + "\n" +
                "   solrNl='" + solrNl + "\', " + "\n" +
                "   solrBe='" + solrBe + "\', " + "\n" +
                "   solrUk='" + solrUk + "\', " + "\n" +
                "   solrDe='" + solrDe + "\', " + "\n" +
                "   nurvisBe='" + nurvisBe + "\', " + "\n" +
                "   nurvisNl='" + nurvisNl + "\', " + "\n" +
                "   nurvisDe='" + nurvisDe + "\', " + "\n" +
                "   sfwUrl='" + sfwUrl + "\', " + "\n" +
                "   sfwRequestBody='" + sfwRequestBody + "\', " + "\n" +
                "   customerRetrieveTimeout=" + customerRetrieveTimeout + ", \n" +
                "   msdBaseUrl='" + msdBaseUrl + "\', " + "\n" +
                "   tosca='" + tosca + "\'" + "\n" +
                '}';
    }
}

