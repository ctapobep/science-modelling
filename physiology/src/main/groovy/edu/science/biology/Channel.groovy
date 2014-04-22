package edu.science.biology


interface Channel {
  enum Antiporter implements Channel {
    Na_K_ATPase
  }

  enum CoTransporter implements Channel {
    Na_Glucose, Na_Amino
  }
}
