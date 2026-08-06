package com.abovebytes.notifications.enums;

public enum OtpStatus {

    // --- 1. Initial / Creation States ---
    PENDING,     // Request created in our system, token generated internally
    ACTIVE,      // Code is valid and actively open for user validation attempts

    // --- 2. Gateway Transmission States (Meta / Twilio / SMS) ---
    ACCEPTED,    // Message accepted by the provider gateway but not yet on the device
    SENT,        // Dispatched by the provider network
    DELIVERED,   // Confirmed delivered to the recipient's phone/app
    READ,        // Handled by Meta webhook confirming the user actively viewed the message

    // --- 3. Terminal / Final States ---
    VERIFIED,    // User successfully entered the correct matching code
    EXPIRED,     // The validation window closed before verification occurred
    FAILED,      // General failure state (e.g., system error, general delivery bounce)

    // --- 4. Security / Hard Lockout States ---
    BLOCKED,     // Recipient phone/IP manually or automatically blacklisted from requests
    LOCKED       // Max input attempts breached; further validation attempts frozen


}
