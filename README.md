# JTQScala

![alt text](https://github.com/devonfw/jump-the-queue/wiki/images/devon4ng/3.BuildYourOwn/jumptheq.png)

A Jump The Queue for Scala and Play Framework

****

Originally, Jump The Queue is an internal exercise by Capgemini that serves as introduction to Devon Framework and internal projects as VIPLane in Campus.

In this repository we have this Jump The Queue approach in Scala with Play Framework. 

***

### Introduction

When visiting public (free) or private (paid) events there are often large queues creating significant waiting times. Ideally the organizer of the event would like to streamline the entry of people into the venue. If people were to arrive right on time they could get into line more efficiently. A website or application could support this process by assigning visitors a queue number. This document describes the design of such a website/application, appropriately named JumpTheQueue.

### Epic and User Stories

#### Epic 1: Register Event

As a visitor of an event, I want to use a website or an app, which — after registration — provides me with a number (and optional date/time), so I can get convenient access to the event.

#### User Story 1: Register
As a user of JumpTheQueue, I want to register with my name, username, password and phone number, comply with the requirements and obtain my queue number.

#### User Story 2: Terms and Conditions
As a user of JumpTheQueue, I accept that the organizer of the event can store my personal data and send me commercial notices (aka “spam”).

#### User Story 3: Join a Queue
As a user of JumpTheQueue, I want to join the queue at the event.

#### User Story 4: List Queued Visitors
As a user of JumpTheQueue, I want to see which queue number is currently being processed and what my own queue number is. Optionally, I want to know the estimated remaining time until it’s my turn.

***

### Problems during development.

#### The application cannot be run in the office.

From experience, no Play Framework application can run from the office because the VPN is blocking. To start the application, the dependencies are downloaded from the console (this fact is blocked by the VPN since these dependencies are downloaded with https certificates).

However, if we are from home without being connected to the VPN, we can work with Play perfectly.

#### Database connection