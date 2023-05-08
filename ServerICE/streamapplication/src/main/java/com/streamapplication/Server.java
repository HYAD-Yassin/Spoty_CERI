package com.streamapplication;



public class Server
{
    public static void main(String[] args)
    {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
        {
        	// Instantiate a new PrinterI servant - the implementation of your Printer
            com.zeroc.Ice.Object servant = new StreamApplicationI();

            // Create object adapter - a container for your servants. Listens on port 10000
            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("StreamApplicationAdapter", "tcp -p 10000");

            // Add the servant object to the object adapter with identity "SimplePrinter"
            adapter.add(servant, communicator.stringToIdentity("StreamApplication"));

            // Activate object adapter - accept incoming requests and dispatch them to servants
            adapter.activate();

            // Wait for communicator to shut down
            communicator.waitForShutdown();

            System.out.println("The server is runing ...");
        }
    }
}