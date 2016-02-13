import org.junit.Test

import static Dna.dna
import static Graphs.overlappedDnas

class GraphsTest {
  @Test void testOverlappedDnas() {
    assert [['AACT', 'ACTA']] == overlappedDnas([dna('AACT'), dna('ACTA')]).collect { it.sequence }
    assert OVERLAP_EXAMPLE1.overlapGraph == tuplesToString(overlappedDnas(Dna.parseFasta(OVERLAP_EXAMPLE1.fasta)))
    assert OVERLAP_EXAMPLE2.overlapGraph == tuplesToString(overlappedDnas(Dna.parseFasta(OVERLAP_EXAMPLE2.fasta)))
  }

  static String tuplesToString(List<List<Dna>> overlappedGraph) {
    String result = ''
    for (List<Dna> tuple : overlappedGraph) {
      result += tuple.id[0] + ' ' + tuple.id[1] + '\n'
    }
    return result[0..-2]//remove last \n
  }

  static final Map<String, String> OVERLAP_EXAMPLE1 = [
      fasta       : '>Rosalind_0498\n' +
          'AAATAAA\n' +
          '>Rosalind_2391\n' +
          'AAATTTT\n' +
          '>Rosalind_2323\n' +
          'TTTTCCC\n' +
          '>Rosalind_0442\n' +
          'AAATCCC\n' +
          '>Rosalind_5013\n' +
          'GGGTGGG',
      overlapGraph: 'Rosalind_0498 Rosalind_2391\n' +
          'Rosalind_0498 Rosalind_0442\n' +
          'Rosalind_2391 Rosalind_2323'
  ]
  static final Map<String, String> OVERLAP_EXAMPLE2 = [
      fasta       : '>Rosalind_8772\n' +
          'AGCAGCATTTAACAGGGCCTACACCAGATTCGGACGCACGCCTGTTTCTGTTCGCTTCTC\n' +
          'GATCGGGAGCATGAATGTCTGACTTCAAGTC\n' +
          '>Rosalind_7617\n' +
          'CGATCACTCCCCAGGCCTGAGGCGACAATTGTAAAGTGCGTAACTCTAGAAATAAGTGAA\n' +
          'AAATAAAAACCCTAAAGCGGAGCTGAGCTACCCTTAAAA\n' +
          '>Rosalind_9642\n' +
          'TCCCCGGTGATTTGATACGGATCATTCCGGGGCCTGGATAAAATTTTATAAGCACTTCTG\n' +
          'CGCGCATGTTGGCATCTGTTACATCGGCACAATTTTC\n' +
          '>Rosalind_6399\n' +
          'ATTGAGGTATGAGGCCTTGCGTGACCAAAAAGTGATACTCCACGACAAGTAGCTTCATAT\n' +
          'CAGAAATATCCGCAGGCCACTGCTTAT\n' +
          '>Rosalind_4108\n' +
          'ACAGCACAGCGACTCCTCTCCCGTGCTTGATCACGTCAATAGAGTTGTTAAAGGGTGATC\n' +
          'CGGGGGTCTGTCGGCCTAGGTCGCCGCA\n' +
          '>Rosalind_7501\n' +
          'CCGCTGCACCTGTAGACCGAGCTTCTCGTAGTCGGGGGCAGTGTCTCTGAGAACGGTGGC\n' +
          'CCGCCTAAGCACCGCGATACTGCAGGGTGGGTGGTATACA\n' +
          '>Rosalind_9383\n' +
          'TGGTATACTGTTCAGATAGCTCTGAAATCAAATCATGACCCTGGCAAGTCGGTAAATCGA\n' +
          'AGGGGTATTGGCTGCCCATTTTCGCATTGATGCCAAA\n' +
          '>Rosalind_9170\n' +
          'TAGGGTGATTGAAGGTGTCATAAAACTCTTTACGCGTGGCTTTCCAGCTATGCGTGAACG\n' +
          'TTGCGTATCGAAGCTCCGATTTTGCAGAACTAGA\n' +
          '>Rosalind_7821\n' +
          'AATGGAGTTCTAAGGTAAAAATCAGGGGGGTCGTAATCAGCTACTGTTACGTTTAGGGAA\n' +
          'CCCGTCTGAAGGTGCTCATATTAACACTGTTT\n' +
          '>Rosalind_6612\n' +
          'TGAATGTCCGGTCAAAAAGGACCCCACAGGAGCAACAGAGCGGAAGCCATTATGTATTCA\n' +
          'AGTGCCGGTGACGGCCTAGGGCGTAGGATTGGCTCG\n' +
          '>Rosalind_7405\n' +
          'ACCTTGATTAACTAGCGTGGCACCGCATAACGAAGGCGGGTATCATACGAATAACGAATG\n' +
          'GTGACTGATTGTAAAAAACGCAGATTTTC\n' +
          '>Rosalind_3975\n' +
          'CTATAGTGATCGCCTACCTCGATTCGACCGTTGCGTTAGTTGCTTGATACGGCCATAGAG\n' +
          'TCACAACTGAAAATGCTTATTAAGGTATCCCTC\n' +
          '>Rosalind_1186\n' +
          'CATAATCGGAGAGAAGAAAGATATAGGCGCACGTAAACCGCGTCAGGTCCATCGCTAGCG\n' +
          'AGTGGGACGCCCGACGAGTTTGG\n' +
          '>Rosalind_9295\n' +
          'CAACCCAGGCTAAGGTGTGATAGGCCGAAGGGCTCGTAAGCTACAGAAAGGTCCTAAATG\n' +
          'TGGCTCCACTGCGGACGATGAGTCCAACAATTG\n' +
          '>Rosalind_0217\n' +
          'GTTCTTTCCGATATCGTAAAGACGACGACGCTGACTTCTGTATCTTGACAACTGCGGCCA\n' +
          'TGCCACATACTTCGGGACGACATTTATCAGTTACGCAAC\n' +
          '>Rosalind_1908\n' +
          'CCTTCTTCGTCCACTTTCACCGCAATATGTTACCCCGACCATTAAGATGCGCCTGACAGA\n' +
          'ATGATAAACGAGAGACGTTTTTTTCGAACAGTGAGC\n' +
          '>Rosalind_6606\n' +
          'GGCTGCCCGCGCCCAATATATGAAATGTACTGTTAAATCTAGTATCTCTGCCATTTAATA\n' +
          'CAGGATGACAAGACTTTCCGATTGCGCACCTAGTTGTTT\n' +
          '>Rosalind_9490\n' +
          'CCCCCCGTACTTTGACTCCCGTGATGGGTGGCTGCATTCGTATCTCCAAAGTTATTCGGC\n' +
          'CACGAGCTCCGGGCAACAACG\n' +
          '>Rosalind_0075\n' +
          'TACAACAGTATCATGTATCAGCACTAGATCTGGATAGCAGGATCCCGACGCGAAATAGTT\n' +
          'CGTGTCGTCACACTAACCTTA\n' +
          '>Rosalind_3124\n' +
          'GCCATTGGAATGAGACGGCCCGAACTTACCGTATCAAACGAATATGGCGTGTATTATCGT\n' +
          'TGTCCTAAACCTCATAAGAGACTATAA\n' +
          '>Rosalind_3448\n' +
          'AAATAACTGGTAAAACAACACGTTGTGCGATAAAAATGGCCCTGGTCCATGTCAAAGCTC\n' +
          'TACCACTAGGGTGGGTGTATGTTGTACTGGGAATCT\n' +
          '>Rosalind_0642\n' +
          'GGCACGCCCCCTAAAGGGGATAACTACGACTGCAAGCGGCAGATTGTGGGATAAACAGCA\n' +
          'CCTTTCAAAAACGGCTTGTATCATT\n' +
          '>Rosalind_8570\n' +
          'TCACCCCGCCTTCCCTCCCGACCATAGGCGCAGCGGGAGTTAGTGCCTGTTTCTTTGTCT\n' +
          'ATAAAGCCCGACGAGCATCGGCGGATAGCAATCCACCTAA\n' +
          '>Rosalind_9819\n' +
          'GCGTCGACCACCGACACGGTCGAACACGTCTCCTGTGTTCGTAGCTTACGGGTGAGCACC\n' +
          'TTAGCAACTTCACCCTAACCCTTAAAAAA\n' +
          '>Rosalind_7977\n' +
          'ATAGAAGTTTCGTTTAACACTTACACACCGAGAACTCCCTCTGCACGGACGGGAGCTCCG\n' +
          'CACGTTAAAAAGCGGGACTGAAAGGTGTAACT\n' +
          '>Rosalind_6896\n' +
          'AAACGGGAGAGGCCACCATGGATCGTAAGGTCATTAGATTGGACACCTACAGTGTTTAAT\n' +
          'CAGGATTGTTGCCTAGCCGGATAAGAGTGACGAGCACAT\n' +
          '>Rosalind_0930\n' +
          'ACGGTGTCTACGGACGGTTTACTATAGGTATCGACCTCAGCATTTGTGCCGCTTTGATGT\n' +
          'CACAGTTTCGACGGAGAAACTTTATCGCTACGCACCACG\n' +
          '>Rosalind_3891\n' +
          'AGAGCAGCCTTTAACGGATCTCTTGAGGAGTAGTCGTACCTGATCAGGCTCTCTATGGTC\n' +
          'TTGCGTTCATCTACGCTTTATTCCTTACGTAGTT\n' +
          '>Rosalind_6635\n' +
          'GGGATCATGGACGTCTGGGCGATCCCGCAACTAACTTGCCTCATAGACACTTGTAGGCAC\n' +
          'AGCAGTAACATAGTGGGGCTGAGCGATATAACA\n' +
          '>Rosalind_2517\n' +
          'CGGGCCCTCAAGCTACGCATTGTTTGATAACGATCTCAAGTGCGGGACAAAACATGTCTG\n' +
          'CGCGGAAACGTGAGGCCCAGGCCAGA\n' +
          '>Rosalind_9857\n' +
          'TCACCAGAGGGAGCCTCGTAAAGGCGGGGCCGCATCAAAGAACGTTCGACGTGTCGTCTG\n' +
          'ACGCTGGATTTTCAGGGTCCCATGCTTTCTAGGTG\n' +
          '>Rosalind_5842\n' +
          'GGCTTATACGGTACCGAAGTCTGCGCTGACAATAACGACTCCACCACCGACCGATATCTG\n' +
          'TCGAGGTTGAAACGAATGTTCTGCACAATC\n' +
          '>Rosalind_4926\n' +
          'GTCGCTGTGATATCATATGGACAACAGTCCAGGTTCTTTAATTCCACATGTGTACGGGAC\n' +
          'ACTCGCAACTGGTAAACGATACAGATGCGA\n' +
          '>Rosalind_4107\n' +
          'CATAACGAGACCATTTTAGATCGACTTAGCAAATTAGGCAAATGTGGGTTTGCTCCTGAT\n' +
          'ATGAGGACACCTTTAAGCTGCCGCTTCTAATTAT\n' +
          '>Rosalind_0103\n' +
          'GTGATAATGTCGCCTGGCCAGCTGCACGGAGAGTGGCGGACGTGTATACTTTAATCGATC\n' +
          'GACGATCCTTTAAAGTCTCACAGTACTTCTGAC\n' +
          '>Rosalind_3921\n' +
          'GACAATCCTTGTAAAAGGCCGCACCATAGCGGAAATTGACCTCCATGCGTGCTTGAAAGC\n' +
          'CATTTGGCAGCTAAGCACCGAACGTCTGTAA\n' +
          '>Rosalind_0263\n' +
          'ATCGGCCAAAATATCGTGATTTTGATCAGGCCTGGTCTCAGGTGGGTAGCTGCGGTTTAA\n' +
          'GTGATGTAGCCCTACACACGGTGATGC\n' +
          '>Rosalind_3753\n' +
          'GATTCCACTTTATCTCAACTTCTTACTTCTCGGGTAACATTTATCGTTCATCGTCGACTA\n' +
          'TCGGCGCGCGCGCGCGCTATCTGCAGCAAGCAGAC\n' +
          '>Rosalind_6276\n' +
          'TGCTGCGAAGCACAGTGTTATCCATCATGAGAGGAACGAGGTTTGATGTACGATTGCTGA\n' +
          'AAACCCCTTTAATTTTAGCAC\n' +
          '>Rosalind_3382\n' +
          'CCTTAAAAAAGGGCCGTACCACTAAAGAACCGATGCAGCTCCCCAATGGTGTGGTACCCT\n' +
          'TACACGCCCGCTATGACCAGCAGAGGACGCAGACT\n' +
          '>Rosalind_4056\n' +
          'AAGAGCCTGACAAACATGCATCACTCTTGCTGAACGTCCTCAGTTTAAGTGGTAGCAACG\n' +
          'AAAACAAGGTTGGTTATTGAATCTGCC\n' +
          '>Rosalind_0432\n' +
          'GGATCCCTCATGTGGCTACTTTAGGACGTTTGCCTAATCAATTTGTGGCGACGTCCCTTT\n' +
          'CTTAATGGCCGCGTCTTCACCATG\n' +
          '>Rosalind_0050\n' +
          'TGTGATCGCCTTGCGAATTTCAACTGAGGACCCGCCTGGAGAACCAGGAGAACAAGAATG\n' +
          'CCTTCGTACTGCCATCCAAAAGAGTTATGCCCTAACGTG\n' +
          '>Rosalind_9757\n' +
          'ATCCCTGTCACAGAGAATGTTTTCATCGCTCTTCGGTGTGTAAGAGGAACCCCAGACCGG\n' +
          'TAGGGTAGGTCTGCATGGCCCCGCCG\n' +
          '>Rosalind_3941\n' +
          'CCAAGTTTCTAAGGAGATCCAAGGACTTACAAGTTACAACTCTGATTAGAGCGCAGGTCC\n' +
          'CTACATGGACGTTGTCCCAACTTAGCT\n' +
          '>Rosalind_8781\n' +
          'GGGACCAGTCAACATTCAATGAAGCATCCAGACCCCGCTTTATTGGCGGTACTCAGTCTT\n' +
          'GTGCTCTATGACGTCACTTCGACGACCATAT\n' +
          '>Rosalind_0250\n' +
          'CTAAGTAGAGAGCGGCCCCTCCCCAATAGGCGAAGTATCGAATTCTGACAGGAGCCTGAT\n' +
          'CATAACTAAATTGAAGGATCAAGTCTTAT\n' +
          '>Rosalind_8451\n' +
          'CGCAATCAGGAGCTATGGGGCGATACGCACACATCCGCGCAGCGAAGACAAGAGAATAAC\n' +
          'TGACTAGAACACATAAGTACGAACCGCCACGTTACTTTC\n' +
          '>Rosalind_7829\n' +
          'GTTCCGCAACTCTACCGAGGCCGGACCGGCACTCCCTTTCTCAAGCCCGAGACATAATAC\n' +
          'CTTCGTCCAGACTATCAAAGTACAGGGTGTTTGTAC\n' +
          '>Rosalind_5524\n' +
          'TTTGAGGCTGTGTCCAAAGTCGTGGAGAAACTAATCGCGCAGGCATAACTTACGTCATCG\n' +
          'CCGCCACATGGCCAGACGATTGACGTATTAT\n' +
          '>Rosalind_7165\n' +
          'CGTGCGTTGGCATGCCGTGGCTCCGGTGATCCTTCGGACTTCTAACTGGCAAGTCCCGCC\n' +
          'GCGCCAGATGCCGTCGCTGATGGAGCTAGA\n' +
          '>Rosalind_5713\n' +
          'TCCGGTACTGACGATCAATATCATCGGAATAGGGTAGGCGAATCGGAGACAGGTGGCCAT\n' +
          'CGAGAGGTTACTGATTAATGTAGTAAAA\n' +
          '>Rosalind_3254\n' +
          'GCCCTGACGCGTCATAACATTGAAAAGAATGCATATGGCCTAATGTATGTTGACACACCG\n' +
          'ATGCTTTGGTCCGCTTTGGGCATTGAGT\n' +
          '>Rosalind_9091\n' +
          'CAGTTAATCTGACGGCACGACTCTGAAGATGTAGCTGCCACTCCCCCTCTCCGCTTAAAG\n' +
          'TTCTTACGAAGTACATCTCTGATGAA\n' +
          '>Rosalind_4791\n' +
          'AATTCATCACTTGGATGTTTGCGCGCCACGGTGCTATTTGGGGGTGCTTGGCGCCTCGCA\n' +
          'ACGGGTCACTGGGCGCGTGTTGACTTGCATA\n' +
          '>Rosalind_0675\n' +
          'AGGCAGCCACATTGGCGCATCCTTATCGCGTTCTGTTGCCTTCGGGCTACTAGTTGGGAC\n' +
          'CTCACAGTGCGTATACCACCCAAATATTTTG\n' +
          '>Rosalind_8883\n' +
          'CCTAAAATCGTTTAGTTTGACTCCGGGGTCATGCGACGGTACTGTGCCCGACCAATAGCT\n' +
          'CTCCAAACTACGCAAATATCGCCTAAACCTGGAA\n' +
          '>Rosalind_9682\n' +
          'AGACTGTGCTGCGAAGCAGATTGCTCGGCCCGAATAAAAGCTATAAGGATTCAGAAATAG\n' +
          'TTCACAATGTGTACCTGCCCGCGGGCGCTGAA\n' +
          '>Rosalind_8701\n' +
          'TATTTATCTTATGATCCCCGACGAACCACGAAAGCAACGAATACTACCTCCTTACGGGCT\n' +
          'GTGGCCAGTCGTAGCGTTGTAGTACAAACCCTCACATG\n' +
          '>Rosalind_4943\n' +
          'GATCTAAACAATCGTTTCCTGGCCTCGGGCTATGACGTAATCATCACAGTGATATCCTTG\n' +
          'TTAATCATTCAACGTTTATTCGCAGCGC\n' +
          '>Rosalind_9220\n' +
          'ACTACAAGTTATCCGGGATGGTGACGAGTAGATGCAGGATTAACCCTAGGACATAGTACA\n' +
          'TTCCTACTGGAGGGTCGCTTTCACTACGTGGTA\n' +
          '>Rosalind_2859\n' +
          'GCCTAAGCCTGGCCAAGAGTTAGCGCCGCCGGCGTGTCTTTTTAGTTGCTGTCAGCTCCA\n' +
          'TGGTGAAGGCCATTGTCCAAGATCGTCTGCG\n' +
          '>Rosalind_0585\n' +
          'CAAACGCGCTTCTTCTAAGACTTATTGGTTCTGAATTACTTGGATGAGAGTTCTGCATGC\n' +
          'ACTTGCCAGTAAGTTTTCTTTGCAAATACCGTTATT\n' +
          '>Rosalind_2821\n' +
          'TATACTATCTTTGCGTTACGTGCTCTCAGCGACGTAACGGGATGTCCAACAGGATCATCA\n' +
          'TATAGAAAGTAACTCAACTTG\n' +
          '>Rosalind_4239\n' +
          'GAGTTGACCAAAACGACGGTGGCACATGAAGTATGGAACTTGTAGGAGAGGACTGCCATA\n' +
          'ACAATAATCGACCTGTGAAGCCCCTAACGCTGCTTAA\n' +
          '>Rosalind_4677\n' +
          'CAAATATCAGATAGCCCAATGCATTGACAAATGAGGAAGTTCACGACGGCTTGTGTCTCA\n' +
          'CACCTCTAGTTGCGAATGTAAACAGGCGATGTGTCCCCC\n' +
          '>Rosalind_8636\n' +
          'TTCGGGCCCTCCCTCAGGAAAGTTTATCACGCAGATCATCGGCGACAGATGCATCATCCG\n' +
          'GTTAAAGCATCTACTCTGAGGGTAAACAGCTTAAAG\n' +
          '>Rosalind_7278\n' +
          'ATAAACTTAGATAACATCGCCGACAAGTATTGAACTCAGATACCCAACCTCCGATCGTCT\n' +
          'TGAAGAGCTTAACATTATATCAAATC\n' +
          '>Rosalind_2519\n' +
          'GGGGGTAGGGGTGGCTTAGTCAAATTTCCACATTGTCAGCTAAGACTGAGTCGTACGTCC\n' +
          'CCGCCGCATACCGAACTCGTGTTGAGCGCAGCA\n' +
          '>Rosalind_9214\n' +
          'CATCATGACACAAGTACCGTCCCTGCATATCATAGACAGCACAGTAAAATATCTAACTCA\n' +
          'CGCTTTCTTTGCACGCTTTTGCA\n' +
          '>Rosalind_7028\n' +
          'TGCCATGCGGTTACACGTGCAGGATTTCATGCCATTCGTGGGATATGAAGGTCTTGGGAG\n' +
          'TAGCTGTCAATCACAAATTTTGGATGCACGTATGGG\n' +
          '>Rosalind_4163\n' +
          'TTCACACAGCCGCATAATAGAGATGAACTATTCACCCCTATATTGTGTCGGCCTGCAAGG\n' +
          'GGCCTGTCCATCAAAACGATA\n' +
          '>Rosalind_1279\n' +
          'AATACAGCGGAACGGTGATGTGATTGGTGGTAGAGTCTAAACGAATATAGCGTTCGGTTG\n' +
          'GGGGCACGAGAACGATTTGATTC\n' +
          '>Rosalind_3205\n' +
          'TGCGCCGGGCATGTATATCAACAAACACTTAAGCCTCCACGGCTAAACATGCTAAGAGCC\n' +
          'ATAACCATTGTTTGGCACTC\n' +
          '>Rosalind_4608\n' +
          'TATATTCATACATCGCCTTACTCCACGTGATGTGAGGTCGCAGACTCCTTGATAATCACT\n' +
          'GACTACTCCTGGAGTTATTGCGCTACCTT\n' +
          '>Rosalind_0796\n' +
          'AATATATGAGAAACCCGTCTGGCGAGGACCACAGTTGCAGACATCCGAAAAAGAAAGATA\n' +
          'ATTCTGAATACTTTCGACGATCGCGTATGTA\n' +
          '>Rosalind_9628\n' +
          'GTGCGTAGCGTAGGTGCACCTTGTCGCTGACGCATATAATGAGGAGTGTATCCTGGCTGC\n' +
          'GTTTTATGCGTTGCAGCGCCCACTAGA\n' +
          '>Rosalind_1513\n' +
          'CGCACCATTAGATCCTTGGAACGTCGGGGGATCAGTCTCTGCAACGATTATATTGTGTCG\n' +
          'TGATCGCTTTGAATAACGTTCCGGCTC\n' +
          '>Rosalind_8987\n' +
          'CGTGCAAGGAGGAACTTGTTATTGATTGGTGACTAGCCGTGAAGAGTTCACGCCGGCATC\n' +
          'CGTATTGCTGACGAAGTCTAATGCTCAGC\n' +
          '>Rosalind_3221\n' +
          'GGTGATATTATCGTCGTTTTAATCGGCTAGCCCACCAGCAAAATATCGCGAAAATCATAT\n' +
          'CCTTCGCCCTCGACGCCCTTTCC\n' +
          '>Rosalind_2019\n' +
          'AGTCTGCCTCACAACTCCAAAAGACCCGATAGAATAGGACGGGCGGTGGCCGCGGAACTT\n' +
          'TATACCGCAAGATTTGAAACGGGTAAAGTACT\n' +
          '>Rosalind_2795\n' +
          'TGTAATCGCACCATATGTACATATTTTAAGTGTAACACCGTAGACCACCGTCGTTCTCCC\n' +
          'CAGAAAGAAGTGAAAGAAGGTATAACGGCC\n' +
          '>Rosalind_2503\n' +
          'GAACAACTAAACACGATGGGCAGAGCTCGAAAGAAGTCGGTTGCTCTGATTTTGATTGAA\n' +
          'TATGTATACCCGTGGAATTGTGAGGCGTGAACGTGGG\n' +
          '>Rosalind_3123\n' +
          'GTGACATGTGTTCCTGCCGAAGTTATATTAGAGAGACATTGAAAGATCCCTACTCCTGCG\n' +
          'CTTGCACAGATCGTTTGACTGAGCGGGGCGCCCTAA\n' +
          '>Rosalind_5455\n' +
          'CTCTACTACAATACCCCTTAGTGAAGTCTCCTACCTCCTCCGTGCCAAAGCATAGATTAT\n' +
          'ATCACTCTAAGTAATGTCAGGCCTCAG\n' +
          '>Rosalind_3929\n' +
          'ACGGCTGAGCTGGCCCCTCTAGTTCCCAGTGCTACTGACATCACTCTCCCGCTAGGAAAC\n' +
          'TAGGGTCTGCTTTAACTCGACGCGCCGGCTCAACATGTTT\n' +
          '>Rosalind_9956\n' +
          'TTGATGCGGAGAATTAGTGAAACCTACTCGCCGGTTGGTGGGAATAGGTGTCATAAGTCT\n' +
          'TCAACTGGCTCACTCGTGACA\n' +
          '>Rosalind_8427\n' +
          'TGGCAATATGCTAGCCCGAGATCAGAGGAGGGGCAAATGCGTCGGGTGGCATTAACCCTG\n' +
          'GTTATGGAAATCTCCTATTAGCAGAGCATGTATTCT\n' +
          '>Rosalind_2049\n' +
          'TCCTTACATCTAGTGGGTCACTAGCTCGTCACGGTTAGGACAACCGCACGGGAACAGCAC\n' +
          'TGAGAGTCGTAGTTCATTATAAAGCGCGGGGCC\n' +
          '>Rosalind_6827\n' +
          'GCTGCTTCCAAGTGTTGTGGAAGGAGAGAGGGCGCTTGTTCGTGGAAATAAAATTCTCCA\n' +
          'CTTGCACATGGACTCCATGATGAAT\n' +
          '>Rosalind_5653\n' +
          'TTACGATCGGGGGAATAATATGGAAGAGCTTCGTCCTTGGGATGAAAACAGCCCGACTGA\n' +
          'CCACCTCAGTGGACGGCTCGGGACTTCGTTTACACAT\n' +
          '>Rosalind_6503\n' +
          'GGAAGTTATAAAATTTCGTAGCCCGGCAAATTGGTCACAGAGTGTTACGTGTTAAATAAT\n' +
          'GGAACGAGGAAAAGTAATGGAGTCACCAAAGACAGTGGGC\n' +
          '>Rosalind_2730\n' +
          'GAACGGTTATGAGATCGGACAAAGATATGACTGGACAGTCGTGTCGCCGCTAGAATCGGT\n' +
          'GCCCATATCTGCTTACTTTCACGAGTCCG\n' +
          '>Rosalind_7987\n' +
          'TGGGCGTTAGAAATATATTAGGTTAAACGCGAGCCCCCCCAGGCGCCGAGATTACCCCTG\n' +
          'TGCCACAAGGAGGCAGATCTGTGAGACCATCACCTTC\n' +
          '>Rosalind_8536\n' +
          'CACTGTAGACCCAGCCGCCTAACGCACTTCCGTGCACCGGTGGGAAATCGTAGGATTGTG\n' +
          'AGACCCTACTACAGCTAAACAACGTA\n' +
          '>Rosalind_3729\n' +
          'TAGCAATAGGGGTGCAGTCTAAGCTACATATGACAAACTTCACGAGAAGTAAACCTGGCG\n' +
          'TCTTCGTCCTTAGGTTGTTATT\n' +
          '>Rosalind_8665\n' +
          'CGGTGCAGCAGTAAGGCATACGCGAGCTATATTGTCTGCCCGTGGGCTTTACTCGATGGA\n' +
          'CGCTTCAGCACTTAGGATCGTTCAACTGT\n' +
          '>Rosalind_7576\n' +
          'TAAGGGTTTCCGTAGACCCGCAAGGACTAGAGATATTCATTCGAATCCTTTACGTGCACT\n' +
          'TTCGCCGCTCAGGTCCTAAGCAAATTCGGGGTGCCGGCC\n' +
          '>Rosalind_8223\n' +
          'GGTTAGGGGAACAGCAGAGTTTATCTATATAAAGCATACAAAGGTGGCGCTCACCGCCTA\n' +
          'GTCGTACAGCAACCGAATACATTA\n' +
          '>Rosalind_2468\n' +
          'TAGCCACACCAAAGAGGGCAAGTGAAGGACAATGCTGACTGGTGAGGTCACATAGCGCTG\n' +
          'TCCGGCCTGCAGGCAATAGCCAATAACATAAGT',
      overlapGraph: 'Rosalind_8772 Rosalind_4926\n' +
          'Rosalind_7617 Rosalind_3448\n' +
          'Rosalind_7617 Rosalind_6896\n' +
          'Rosalind_9642 Rosalind_8636\n' +
          'Rosalind_9642 Rosalind_4163\n' +
          'Rosalind_6399 Rosalind_8701\n' +
          'Rosalind_6399 Rosalind_2821\n' +
          'Rosalind_6399 Rosalind_4608\n' +
          'Rosalind_7501 Rosalind_4108\n' +
          'Rosalind_9383 Rosalind_3448\n' +
          'Rosalind_9383 Rosalind_6896\n' +
          'Rosalind_9170 Rosalind_3891\n' +
          'Rosalind_9170 Rosalind_9682\n' +
          'Rosalind_7821 Rosalind_5524\n' +
          'Rosalind_7405 Rosalind_8636\n' +
          'Rosalind_7405 Rosalind_4163\n' +
          'Rosalind_3975 Rosalind_5455\n' +
          'Rosalind_1186 Rosalind_9383\n' +
          'Rosalind_1186 Rosalind_8427\n' +
          'Rosalind_1186 Rosalind_7987\n' +
          'Rosalind_9295 Rosalind_9956\n' +
          'Rosalind_1908 Rosalind_8772\n' +
          'Rosalind_6606 Rosalind_5524\n' +
          'Rosalind_9490 Rosalind_0930\n' +
          'Rosalind_9490 Rosalind_3929\n' +
          'Rosalind_0075 Rosalind_5653\n' +
          'Rosalind_3124 Rosalind_7576\n' +
          'Rosalind_0642 Rosalind_6399\n' +
          'Rosalind_8570 Rosalind_7576\n' +
          'Rosalind_9819 Rosalind_3448\n' +
          'Rosalind_9819 Rosalind_6896\n' +
          'Rosalind_7977 Rosalind_9220\n' +
          'Rosalind_6896 Rosalind_1186\n' +
          'Rosalind_6896 Rosalind_4107\n' +
          'Rosalind_6896 Rosalind_9214\n' +
          'Rosalind_0930 Rosalind_3929\n' +
          'Rosalind_3891 Rosalind_0217\n' +
          'Rosalind_3891 Rosalind_7829\n' +
          'Rosalind_6635 Rosalind_4108\n' +
          'Rosalind_2517 Rosalind_3891\n' +
          'Rosalind_2517 Rosalind_9682\n' +
          'Rosalind_9857 Rosalind_0103\n' +
          'Rosalind_9857 Rosalind_9628\n' +
          'Rosalind_9857 Rosalind_3123\n' +
          'Rosalind_5842 Rosalind_0263\n' +
          'Rosalind_5842 Rosalind_9757\n' +
          'Rosalind_4926 Rosalind_7617\n' +
          'Rosalind_4107 Rosalind_8701\n' +
          'Rosalind_4107 Rosalind_2821\n' +
          'Rosalind_4107 Rosalind_4608\n' +
          'Rosalind_0103 Rosalind_3921\n' +
          'Rosalind_3921 Rosalind_7576\n' +
          'Rosalind_0263 Rosalind_6276\n' +
          'Rosalind_0263 Rosalind_7028\n' +
          'Rosalind_0263 Rosalind_3205\n' +
          'Rosalind_3753 Rosalind_3921\n' +
          'Rosalind_6276 Rosalind_8536\n' +
          'Rosalind_3382 Rosalind_9220\n' +
          'Rosalind_4056 Rosalind_3124\n' +
          'Rosalind_4056 Rosalind_3254\n' +
          'Rosalind_4056 Rosalind_2859\n' +
          'Rosalind_0050 Rosalind_0103\n' +
          'Rosalind_0050 Rosalind_9628\n' +
          'Rosalind_0050 Rosalind_3123\n' +
          'Rosalind_9757 Rosalind_7501\n' +
          'Rosalind_3941 Rosalind_6827\n' +
          'Rosalind_8781 Rosalind_8701\n' +
          'Rosalind_8781 Rosalind_2821\n' +
          'Rosalind_8781 Rosalind_4608\n' +
          'Rosalind_0250 Rosalind_8701\n' +
          'Rosalind_0250 Rosalind_2821\n' +
          'Rosalind_0250 Rosalind_4608\n' +
          'Rosalind_8451 Rosalind_8636\n' +
          'Rosalind_8451 Rosalind_4163\n' +
          'Rosalind_7829 Rosalind_0075\n' +
          'Rosalind_5524 Rosalind_8701\n' +
          'Rosalind_5524 Rosalind_2821\n' +
          'Rosalind_5524 Rosalind_4608\n' +
          'Rosalind_7165 Rosalind_3891\n' +
          'Rosalind_7165 Rosalind_9682\n' +
          'Rosalind_5713 Rosalind_3448\n' +
          'Rosalind_5713 Rosalind_6896\n' +
          'Rosalind_3254 Rosalind_2019\n' +
          'Rosalind_9091 Rosalind_2503\n' +
          'Rosalind_9091 Rosalind_2730\n' +
          'Rosalind_4791 Rosalind_7977\n' +
          'Rosalind_4791 Rosalind_7278\n' +
          'Rosalind_0675 Rosalind_9956\n' +
          'Rosalind_8883 Rosalind_2503\n' +
          'Rosalind_8883 Rosalind_2730\n' +
          'Rosalind_9682 Rosalind_2503\n' +
          'Rosalind_9682 Rosalind_2730\n' +
          'Rosalind_4943 Rosalind_8451\n' +
          'Rosalind_4943 Rosalind_1513\n' +
          'Rosalind_2859 Rosalind_9819\n' +
          'Rosalind_0585 Rosalind_6399\n' +
          'Rosalind_2821 Rosalind_9956\n' +
          'Rosalind_4239 Rosalind_7576\n' +
          'Rosalind_4677 Rosalind_9490\n' +
          'Rosalind_8636 Rosalind_4056\n' +
          'Rosalind_7278 Rosalind_0263\n' +
          'Rosalind_7278 Rosalind_9757\n' +
          'Rosalind_7028 Rosalind_6635\n' +
          'Rosalind_7028 Rosalind_8781\n' +
          'Rosalind_7028 Rosalind_2519\n' +
          'Rosalind_4163 Rosalind_7977\n' +
          'Rosalind_4163 Rosalind_7278\n' +
          'Rosalind_1279 Rosalind_8636\n' +
          'Rosalind_1279 Rosalind_4163\n' +
          'Rosalind_3205 Rosalind_5455\n' +
          'Rosalind_9628 Rosalind_3891\n' +
          'Rosalind_9628 Rosalind_9682\n' +
          'Rosalind_1513 Rosalind_5455\n' +
          'Rosalind_8987 Rosalind_8772\n' +
          'Rosalind_3221 Rosalind_9642\n' +
          'Rosalind_3221 Rosalind_5713\n' +
          'Rosalind_3221 Rosalind_2049\n' +
          'Rosalind_2019 Rosalind_9220\n' +
          'Rosalind_2795 Rosalind_3124\n' +
          'Rosalind_2795 Rosalind_3254\n' +
          'Rosalind_2795 Rosalind_2859\n' +
          'Rosalind_2503 Rosalind_6635\n' +
          'Rosalind_2503 Rosalind_8781\n' +
          'Rosalind_2503 Rosalind_2519\n' +
          'Rosalind_3123 Rosalind_7576\n' +
          'Rosalind_5455 Rosalind_9091\n' +
          'Rosalind_3929 Rosalind_5524\n' +
          'Rosalind_9956 Rosalind_4108\n' +
          'Rosalind_2049 Rosalind_3124\n' +
          'Rosalind_2049 Rosalind_3254\n' +
          'Rosalind_2049 Rosalind_2859\n' +
          'Rosalind_6827 Rosalind_7821\n' +
          'Rosalind_6827 Rosalind_4791\n' +
          'Rosalind_6827 Rosalind_1279\n' +
          'Rosalind_6827 Rosalind_0796\n' +
          'Rosalind_5653 Rosalind_1186\n' +
          'Rosalind_5653 Rosalind_4107\n' +
          'Rosalind_5653 Rosalind_9214\n' +
          'Rosalind_6503 Rosalind_6606\n' +
          'Rosalind_6503 Rosalind_0642\n' +
          'Rosalind_6503 Rosalind_5842\n' +
          'Rosalind_2730 Rosalind_7501\n' +
          'Rosalind_7987 Rosalind_8636\n' +
          'Rosalind_7987 Rosalind_4163\n' +
          'Rosalind_3729 Rosalind_6399\n' +
          'Rosalind_8665 Rosalind_0050\n' +
          'Rosalind_8665 Rosalind_2795\n' +
          'Rosalind_7576 Rosalind_3124\n' +
          'Rosalind_7576 Rosalind_3254\n' +
          'Rosalind_7576 Rosalind_2859\n' +
          'Rosalind_8223 Rosalind_5653\n' +
          'Rosalind_2468 Rosalind_2019'
  ]
}
