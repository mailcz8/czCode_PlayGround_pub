package main

import "fmt"

func main() {
	var conferenceName = "Go Conference"
	const conferenceTickets float32 = 50
	var remainingTickets = 50

	fmt.Println("Welcome to", conferenceName, "booking application", conferenceTickets)
	fmt.Println("We have total of", conferenceTickets, "tickets and", remainingTickets, "are still avaliable.")
	fmt.Println("Get your tickets here to attend")

	// if remainingTickets == 0 {
	// 	//end program 
	// 	fmt.Println("Our conference is booked out. Come back next year.")
	// 	break
	// }

}
