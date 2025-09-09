from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route("/sentiment", methods=["POST"])
def sentiment():
    data = request.json
    text = data.get("text", "")
    # Dummy sentiment logic
    if "good" in text.lower():
        result = "positive"
    elif "bad" in text.lower():
        result = "negative"
    else:
        result = "neutral"
    return jsonify({"sentiment": result})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
