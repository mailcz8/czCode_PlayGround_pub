import openai
import pyttsx3

openai.api_key = "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"

# Set up text-to-speech engine
engine = pyttsx3.init()

# Set up initial prompt
prompt = "Hello, how are you?"

# Start conversation loop
while True:
    # Get user input
    user_input = input(prompt + "\n")

    # Exit loop if user types "exit"
    if user_input.lower() == "exit":
        print("Goodbye!")
        break

    # Add user input to prompt
    prompt += "\nUser: " + user_input.strip()

    # Generate response from ChatGPT
    response = openai.Completion.create(
        engine="text-davinci-002",
        prompt=prompt,
        max_tokens=60,
        n=1,
        stop=None,
        temperature=0.7,
    )

    # Extract and print ChatGPT's response
    chatgpt_response = response.choices[0].text.strip()
    # print("first response = ", chatgpt_response)
    # Remove any parts of the prompt that have already been spoken by ChatGPT
    prompt = prompt.replace(chatgpt_response, "", 1)

    # Print ChatGPT's response
    print("ChatGPT:", chatgpt_response)

    # Speak ChatGPT's response
    engine.say(chatgpt_response)
    engine.runAndWait()