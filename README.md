# Daily Wisdom App - Backend

## Overview

The Daily Wisdom App backend is responsible for generating random quotes from the [Quotable API](https://example.com/quotable-api) and allowing users to send these quotes to an email recipient using JMS.

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

## Hosting, Deployment, and Access

The backend of the Daily Wisdom App is hosted on a free instance provided by [Render](https://render.com). Please note that due to the nature of the free instance, it may spin down during periods of inactivity. This could potentially delay the initial request by 50 seconds or more.

The web service is deployed using a Dockerfile. This allows for a consistent and reproducible environment, regardless of where the application is being run.

The web service can be accessed through the following link: [https://dailywisdombackend.onrender.com](https://dailywisdombackend.onrender.com)