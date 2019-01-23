package main

import (
	"C"

	"github.com/cdipaolo/sentiment"
)

//export ClassifySentiment
func ClassifySentiment(text string) uint8 {
	model, err := sentiment.Restore()

	if err == nil {
		return model.SentimentAnalysis(text, sentiment.English).Score
	}
	return 2
}

func main() {}
