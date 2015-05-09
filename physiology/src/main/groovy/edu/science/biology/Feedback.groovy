package edu.science.biology

class Feedback {
  enum ComponentsOfFeedback {
    Stimulus("afferent"), Sensor("afferent"), IntegrationCenter("efferent"), Effector("efferent", "response")
  }

  enum CellControlMechanism {
    Endocrine, Neuron, Paracrine, GapJunction, Autocrine;
  }
}
