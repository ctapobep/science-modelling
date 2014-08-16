package edu.science.biology

class Internet {
  class Databases {
    def withApi = ['http://aidsinfo.nih.gov/api': 'drugs']
    def withoutApi = ['http://www.drugbank.ca/': 'drugs', 'http://www.drugs.com/': 'drugs',
                      'http://www.mayoclinic.org/': ['drugs', 'disease'],
                      'http://reference.medscape.com/drug-interactionchecker': ['drugs'],
                      'http://www.drugs.com/drug_interactions.php': ['drugs']]
  }
}
