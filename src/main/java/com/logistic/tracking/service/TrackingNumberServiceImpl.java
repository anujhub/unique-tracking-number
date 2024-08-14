package com.logistic.tracking.service;

import com.logistic.tracking.entity.Product;
import com.logistic.tracking.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.UUID;

@Service
public class TrackingNumberServiceImpl implements TrackingNumberService {

    private Logger logger = LoggerFactory.getLogger(TrackingNumberServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    private static final ThreadLocal<SecureRandom> secureRandomThreadLocal = ThreadLocal.withInitial(SecureRandom::new);
    private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

//Solution 1

    /**
     * Method to return unique 16 digit Id based on available data present in database
     *
     * @return tracking number
     */
    @Override
    public String generateTrackingNumber() {
        logger.info("generating unique tracking ID");
        String uuid = null;
        Product product = null;
        do {
            uuid = generateUniqueId();
            product = productRepository.findById(uuid).orElse(null);
        } while (product != null);
        return uuid;
    }


    public static String generateUniqueId() {
        StringBuilder uniqueId = new StringBuilder(16);
        SecureRandom secureRandom =   secureRandomThreadLocal.get();
        for (int i = 0; i < 16; i++) {
            int index = secureRandom.nextInt(ALPHANUMERIC_CHARACTERS.length());
            uniqueId.append(ALPHANUMERIC_CHARACTERS.charAt(index));
        }
        return uniqueId.toString();
    }


    //Solution 2

    /**
     * Method 2 to generate a unique id
     */
    public String getTrackingNumber(){
        String uuid = UUID.randomUUID().toString();
        return UUID.randomUUID().toString();
    }

}
