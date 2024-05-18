# Daily Wisdom App - Backend

## Overview

The Daily Wisdom App backend is responsible for generating random quotes from the [Quotable API](https://example.com/quotable-api) and allowing users to send these quotes to an email recipient.

## Endpoints

1. **Random Quote Endpoint**:
    - **URL**: `/api/quotes/random`
    - **Method**: GET
    - **Description**: Retrieves a random quote from the Quotable API.

2. **Send Quote by Email Endpoint**:
    - **URL**: `/api/email/send`
    - **Method**: POST
    - **Parameters**:
        - `quoteId`: ID of the quote to send.
        - `email`: Email address of the recipient.
    - **Description**: Sends the selected quote to the specified email address.