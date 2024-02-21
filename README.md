Learnings from  Hands-On Reactive Programming with Java 12 and Reactive-Programming-in-7-Steps

Reactive API – Overview
* Flow: The Main Entry Point of Every Reactive App
* Subscriber versus Publisher: When to Use Which
* Hot Publisher: Why It Is Hard to Take Control Over It
* Cold Publisher: Pairing with Back Pressure

Publishing and Consuming Messages: Starting Stock Exchange Application
* Consuming Messages: Creating a Subscriber
* Using Publisher to Emit Stock Events
* Testing Stock Reactive Flow
* Handling Errors in Subscriber

Transformation of Messages
* Flow.Processor API for the Skeleton of Transformation
* Using SubmissionPublisher for Proxying Event to Another Publisher in the Chain
* Plugging the TransformProcessor for Transformation Logic
* Testing Stock Transformation Logic

Solving the Problem of Overproducing Publisher with Backpressure
* Leveraging Subscription Object for Controlling the Number of Fetched Stocks
* Controlling the Speed of Consumer with AtomicInteger
* Creating Overproducing Publisher
* Testing Backpressure in Stock Exchange Application

Reactive Java 12 with Alternative Implementations
* RxJava – Advanced Operations – flatMap
* Reactor – Flux
* Reactor – Combining Publishers

Reactive Microservices
* Reactive Spring Boot
* Creating Reactive Data Access Layer
* Creating Reactive Controller
* Testing Reactive Microservices

