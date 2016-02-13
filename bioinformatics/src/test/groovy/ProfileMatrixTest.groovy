import org.junit.Test

import static Dna.dna

class ProfileMatrixTest {

  @Test void 'building a Profile Matrix out of DNAs'() {
    assert [[], [], [], []] as int[][] == ProfileMatrix.fromDnas([dna('')]).profile
    assert [//one DNA string should return 1 at every position only for one letter
            [1, 0, 0, 0],
            [0, 1, 0, 0],
            [0, 0, 1, 0],
            [0, 0, 0, 1]] as int[][] == ProfileMatrix.fromDnas([dna('ACGT')]).profile
    assert [//2 DNA strings
            [1, 0, 0, 1],
            [1, 2, 0, 0],
            [0, 0, 2, 0],
            [0, 0, 0, 1]] as int[][] == ProfileMatrix.fromDnas([dna('ACGT'), dna('CCGA')]).profile
    assert CONSENSUS_EXAMPLE1.profile == ProfileMatrix.fromDnas(Dna.parseFasta(CONSENSUS_EXAMPLE1.fasta)).profile
    assert CONSENSUS_EXAMPLE2.profile == ProfileMatrix.fromDnas(Dna.parseFasta(CONSENSUS_EXAMPLE2.fasta)).profile
  }

  @Test void 'getting consensus out of DNAs'() {
    assert '' == ProfileMatrix.fromDnas([dna('')]).consensus()
    assert 'ACGT' == ProfileMatrix.fromDnas([dna('ACGT')]).consensus()
    assert 'ACGA' == ProfileMatrix.fromDnas([dna('ACGT'), dna('CCGA')]).consensus()
    assert 'ACGA' == ProfileMatrix.fromDnas([dna('ACGT'), dna('CCGA'), dna('ATCA')]).consensus()
    assert CONSENSUS_EXAMPLE1.consensus == ProfileMatrix.fromDnas(Dna.parseFasta(CONSENSUS_EXAMPLE1.fasta)).consensus()
    assert CONSENSUS_EXAMPLE2.consensus == ProfileMatrix.fromDnas(Dna.parseFasta(CONSENSUS_EXAMPLE2.fasta)).consensus()
  }

  static final CONSENSUS_EXAMPLE1 = [
      fasta    : '>Rosalind_1\n' +
          'ATCCAGCT\n' +
          '>Rosalind_2\n' +
          'GGGCAACT\n' +
          '>Rosalind_3\n' +
          'ATGGATCT\n' +
          '>Rosalind_4\n' +
          'AAGCAACC\n' +
          '>Rosalind_5\n' +
          'TTGGAACT\n' +
          '>Rosalind_6\n' +
          'ATGCCATT\n' +
          '>Rosalind_7\n' +
          'ATGGCACT',
      profile  : [
          [5, 1, 0, 0, 5, 5, 0, 0],
          [0, 0, 1, 4, 2, 0, 6, 1],
          [1, 1, 6, 3, 0, 1, 0, 0],
          [1, 5, 0, 0, 0, 1, 1, 6]
      ] as int[][],
      consensus: 'ATGCAACT'
  ]
  static final CONSENSUS_EXAMPLE2 = [
      fasta    : '>Rosalind_8623\n' +
          'CATATGCGCTTCCACAAAATCTGCTGGGTCGAACCGGATTGTAGGGGATGCTGAAAGCAG\n' +
          'TCCTCAGCTCGTTGCGCCAGTACAATCTTAAAGCTACGATCTCTGACCCTATAGCGAAAG\n' +
          'GTTCCATATGTTGGTATTCGCCGGCGATTAGCTTTGTGTACCTCTTCTGTCTAAGCATCG\n' +
          'CGGTCGGCCTGGGAATGCTTCAACAACACGTTCTTTGGCGTGAGACACCTGAATGATGAT\n' +
          'CTGCCACCTATAATATCTGCAACGTGTGACCGCTATCTCTTAATATAGCTGCCTTTAGGC\n' +
          'CGGTTACCCCTCAGAAAGTGGGCCTCTGGAGCGCTCTAAGGCGACCCTCGGTAGCGGGTC\n' +
          'AAGGGCTACAGGGTGGGTTTGAAGCATTCTGACAGCTGAGGGCCAGAATAATCAGCACAG\n' +
          'CACAACTTAACAGAATCTGTCACGAGTGAATTGGCAGTCTAGGCCATGTGCGCAACCTGC\n' +
          'TACACACACTGAATCAATCGGTACACTATGCACACAGCGGGGATGTTCGGTCTTTCACAG\n' +
          'GAAGTTGCTATACCTTTATTGGTCCTGACCGAGGACGTTACTTAGAGTCCCACTATAACG\n' +
          'CTTGACAGCTGTGTCCGATGATAGTAGTTTCGCTAACGGGTGCGGCGATGTTATGCCTTC\n' +
          'ATGAACCGGATGTGTCATAAAGTTCAGCAAAAAGGATCCACTCGAGACTCCCGGTGTCTC\n' +
          'GACCATGCTCTAATCTAAAAGATCTACCTGTAGTCGCATCGCCAGCTGACCTTCCACCAG\n' +
          'GTGGGGCATTGCGTCACGTAAGCAGAATACTCTGCGCTTCTGCGTGGACTCCGACGTGTG\n' +
          'CTACTCGGCTTATGAGTATACGGTAGTGAGAACTATCCCACGAGTATATAAAGGCTAATG\n' +
          'TGAGACGCTGGGGACTATCTCTTGA\n' +
          '>Rosalind_2680\n' +
          'GTCGGGAGTGCCACGTGACGAACCCATGTGGCACGCCAATACTCTACCTTATCCACATTT\n' +
          'CCGACTGGGCGCCTGCTGCGCTCGATGTTGCGATCTTCCCCCCCATCTAGTTACGCATGC\n' +
          'TCTCTATTCTCAAAATCTGTACCCTTAGCTTGTGCCTGGAAGGCTACGGATCAACCGTAC\n' +
          'ATCCGCTAGAACCTCATCGGTACCAGGTGAGGTAAATTAGGCATGCTCGCCGTAAAATTG\n' +
          'CGTGTCCATTCCCTCGTAGGTTCATAGATATAGCAAGACGTGCGCGGGAGGTATCCCATA\n' +
          'ACATTATTCCCATACTGAGCGCGAGTAGGCATCTTCTATGCATATGACTACAACGAGGGC\n' +
          'CTCGTTACGCCATCTTTCCCTCTGGCCGTCAGTAGCCGTCCGAGCGCACCGACCAATCTC\n' +
          'ACGGCGAACAGAGAACACATCTTAACTGTGACCTGACGATCACACTTACTCGGGCATATG\n' +
          'CAGCCTCCGCTGCGCGACATGACTCTAGCAGCAGCACCTCCGCAATGGCAAAAGGTTTGC\n' +
          'AGAAATTGCATACTAGGACGAAAATTAGACTGTATGCGGGAGATAGACTAACAGTGGCTG\n' +
          'ATGGTCGTCGATCCAGTAGTGAACAAGTACATCTCATGGGTCCGGAAGCACGGGATCGTC\n' +
          'TTGCTAGAGACGGTCGTCTAAGCACGCAACTGATTAAAGGATAGCATGGGTTTAATGAAG\n' +
          'TCAATGAGTTGTGATGCGCCACGAGAACCGCCGGAGGCGAGACACAGCCTGCCAACTAAA\n' +
          'CAGCGTCAACACCGACGTCGACTCGCAGACCTTTCACACCACGTTGGTGGCCAATAACCT\n' +
          'AGGACGTACCGATATCGTGTTCGCTCCTATGTTAAAGCGAGAACATGTCATCAGTAGCGG\n' +
          'CCGGTATACGGGCCAAAACTTATCA\n' +
          '>Rosalind_9749\n' +
          'GGTTACTCGCTTGTATACAAGATGGTAGAGGATTAGTCATCGGTCTCATCCGGACCTTGT\n' +
          'TAATTGTCATTCCGTGAGAGCCCTGTAGCCTCAGAGCATACAGTAAGCTCATATCCATAC\n' +
          'GACTAGGGGTCAAATTTCCTGGATTTTAGGCGAAGGCATCCTGCTAAATTCACCGACGGC\n' +
          'GACCTTGACGCGAAGTAGTCATATCCTCATTATCCACTAACTGGAGCTGACTTGTGACGG\n' +
          'TGGGTAAACATGTCCATGACGAACATGTGCCGAGCGGGTCTGGCTTCTGAAACTAGCCGT\n' +
          'GGGCCAAAGTACCGCGAAGCCCCCTTAGCTACGCCATGCTCACACTTCGAAGTCTGGTTT\n' +
          'CGGTTTGAATGTCGTCGGGAGAACCAAGAGCAAGCCCCGGTGTAGACGAATGCGGCAAGG\n' +
          'ATATAAATGCTACGACCCAGTCTACAACTGCGGCTTCACATCCAGACTATCGCCGTATCC\n' +
          'TAGGGTGTACAGCCTTTAAGACTCGTTGCGGTGTTAAGTTCGGGGAGAATCTTGCACCCG\n' +
          'CCGTGATAGTCGGTGGAAAGATCGCGGCAAGTAGAACACATTAACACTGCAGAAGCTTAT\n' +
          'ACTCATTCGTGCCCCCACACGCTTGCCTTAGCCGGATCATGGTATACGTCGATTCTCGAC\n' +
          'GCAGTCATTTTGCTACCAGGCTGCCTTGCGGCATGCTTGTCGAACGGACTATCCCGAGAA\n' +
          'CGACAGAGTAGCCCGGTAATTCATATTCCTCTGATGAAACCCACCCGTTGGTTTCAGTAT\n' +
          'GGCACAAAGTGGTAAGCCTGCAATCAGTGCAGCAGGGCCAAGAACCAGGGGTAAATAGGC\n' +
          'GCTCCAGGGCTTACTGCAATGTGGAGGGGAACCAGTACTAGGGGGGACACCGTTTCAGTC\n' +
          'CCGGGACTTGAATCTTGAAGGTTAC\n' +
          '>Rosalind_1202\n' +
          'CTGTACCAGCTGGAGTGGCTTTGTTCATGGCCAAAACTAACAGTTTCTATAGGCACACCG\n' +
          'TCCAGAACTGATCCGGCGTTTAAACATTATTGGGGCCGGCAGGTACTTCATGTTTATACA\n' +
          'GGCACGTAACTTTCGTAGTACTATAGTCTACATCATCGCGGATCGTATCTACGCTGCTTT\n' +
          'ACACAAAGGAAGCGAGATACTCTAAAACGGAGACCAACACTCAGCGTCGCCACGTACAAA\n' +
          'CCACTGTACCGAAGACAAAGGTGTATATGAACAGAACATAGAGTATTGCTCAAACACGCG\n' +
          'GGACTTGTGATCCTCCGTTAAGCCCCGCTACGCCCGTTTGGGAAGTACGGGAAGCCATAA\n' +
          'CCGTCAAAAAAGTGCCAGTCGAGTGCGCAAGGAGAGCAAGACATAAAGCTAGGTCTGGTC\n' +
          'CGACATGAGCCTGCCCGCGAATCTTGTACTAAGAACCGTCAATGGCCACTGGAAGGTCCG\n' +
          'CGAGTTCGATAATAGTACCCTGCCTGGTGTTTCTTTGGCAATAGACGTGCTAGATAAGTG\n' +
          'ACCATGCAGGCCACTCCGTCTAACTGCTGCCTAGTCATGAATTCAGAGTGCCAAGCGGGA\n' +
          'ACAACACTTCAGTCAGCTCCTAACTTTATGCATTAGCCTTAGGTCTTAGTTTTGGGATGG\n' +
          'CCGCGGCCAAGTTAAATTCTGGTGTCAGTTTTTACCAAGGAGTCGACACGAAACTAAGCT\n' +
          'TTCTACCACAAGGCCCTATTTGATGCCCTTATCTACTGCCCACTGTGATATGGAGCTATT\n' +
          'TTGGATTTTCTAGAGCATGAAAGCGTGATCCTGTGTTTTGGGAGTTGTGTCCTGGGAGAG\n' +
          'CAGTTTATACAGTCTACCGAGCGGAACACTCTGCAAGTAGTGTAAAACAATGCGTGGGGC\n' +
          'ATATCCGGCGCCTGTCCATGCATAC\n' +
          '>Rosalind_0783\n' +
          'TAGTGACGTATTCCGTCGGAGGAGGCTGATCCAGAGAAAATGGTAGGACCGTTCACAGCC\n' +
          'TAGTCGATGCAGTCCGCCGATATGTACTCGGACGTTAAGGTATCATAGTTCCCAAGCTAA\n' +
          'TTACCAGCCTAAGTTGAAGGCTTTAGGCACGAAGTGGTGCGATGCAACGAACCCACCCGT\n' +
          'CCTTACTTAAGCAGGGCTTCACCGGTTATCGCGCGCGACCGAGATAACAGACCCAGAATA\n' +
          'TATCCTGGGGCAAGGGTCAGTACCATGGTCGCTGGACTCTGGGGATCGTACTAACAGACA\n' +
          'GGTATTTAAGCGGCGTTAGCCGACCCGCCCCTCAGGGAGCTTCAAATGCAGGGCGATAAA\n' +
          'TATAATACCCCACCAAGTTCAATTACGATAAAAGTTTCCCTGATCACAGCGTGTACAAGC\n' +
          'TAAGCGCGATGAATACCTGCCAAAAGCTGAACGGAGGTACTATAGATGTGACCTCGTAGA\n' +
          'ATCTATACAATGCGCTCGTACTATCGAGCAGTCAAGCCAGCCCGATAGTGTAAAGATTCC\n' +
          'GAGCGAATACCGTGCCTCCGAGGATAGGCTTTACCTTACTGGGGGGTCTGGAGGACAGGC\n' +
          'GTTACCACGTTGCATCACATACGTCTTCAAAATTCTCGCAGGGTACCAATTTGCACAGTA\n' +
          'TACACCAGCGACTGTTTCAAAGGGCGGCAGCGCGTGTGCTAACGCGGGCTCTCAAGGCCA\n' +
          'GAGTGGAACCTGTCGCTACATTGTTAGGCCTCATCATAGTAAGCATTACAACCACATAGT\n' +
          'GTCCTGCGTTAGATGTAATTATATTCCTCCTCGCGGGTCAGGGCTTCTATACAGGTCGTA\n' +
          'TGAGGTGACGTCTCTGTCACCAAGCACGATAGTTCACAGGGCGGTTGCCGCCTGTACATG\n' +
          'TCGCAAATGTCCTCGAAAAGTGTCA\n' +
          '>Rosalind_7322\n' +
          'ACGTTCTTAATAGTTCAGCAGAAAATACCGCCCGTTGGACGTCACCGTAACACAAACGTG\n' +
          'CTTCGGTACGGGTAATCGCCCAATCTAAGGGACGGCTTATGGGCTTTGTCGCGACCTTGG\n' +
          'ATTCTTAGCCAGCAGTCAAGCAGGCCTTTCTGGGAGCGTTGTTACCCGCCAGTCAGGTCT\n' +
          'GACCGCGTCCCTGCAACATATTTTAAGGTGCCCAACTCGAAACGTTGGAAAAGATAGTAC\n' +
          'AAGCGGACCGAGGGCGCGGTAACCAATGCGACTGGTGAGTTAAGGCGCGAGCCATTAAAA\n' +
          'TGCAGACTAGCTCAACGTAATAGACGTTAGTGCTATATCACCCCCCAAAAGCTAATGACA\n' +
          'ATACTCTATGCCAGTATCTCCGCAGAGAGCTGCCCTCTCATTAGACCTTCCCTAACGAAT\n' +
          'TTAAGCGTATTGCCCGGCAGCCTCTAACTTCAGTAACAACTGTCCAGGCAAGTCAGACGG\n' +
          'CGTTACGCTCGGTCTAACTCAGTAGGGCCCAACGAGCGGATCTACCCATAGTATTAAACA\n' +
          'TGCTATCATGTCTCTGGCGTCCTGGCCCATTTATTCATTTATTGGTCAATCATATCTGTG\n' +
          'CTCACTATGCTCTCACCTTCGTTGCTGTCTGTCGCCACCGCAGGGTTAATAAATTGGGTA\n' +
          'TACAAATTGTCAGGTAATACAACCCATTAAAACGCTAAGACCCGACCCGGTGGCGGCCAC\n' +
          'TCTCGAAACTCTATCAAGTGGGGCTGGACCCCTGACGAGGTCTAACCACTTGGTCTAAGG\n' +
          'TGACTTAGGTGCGGTGCCCAGAGAATCGATCACCACGGTATTGGAAGCATAGTGGCGATC\n' +
          'TAACCCACCGGATAGCGGCTAATAAAGGAAGATGGCATCCTACGGATCTAATGAACGTGA\n' +
          'GGATTGGGGCTGATGGGAGTGAGTC\n' +
          '>Rosalind_1682\n' +
          'GTTCGTGTTAGGTTTTTCCCACGCGGCAAAAGCAAAGGGATTTTATGTACTCCGGGCGCA\n' +
          'CCCATTGGCATGTATGACCGCTCCCCCATAGGGGGAGGAAGATAGTAGTCGTTGACTTCC\n' +
          'TAAGGAGAGAGAGCCCCTACTTTGAAAGTCATATCGGGTTACAGCTATGAGACCAGTAAT\n' +
          'CTAATCCGACGCACTACCCTAGACTAGCTCGGATTACCACTAGGAAGTCAAGCTATTGGA\n' +
          'ATACAGCACGCGCTTCTGGCAGACTCCCATCGTTTCGTTTTTCAGGGTAGCCAGGAGGGC\n' +
          'CGTGGAGAGTGACCTCTTAGGTGCCGTTATGCCCGTCGTCGCCCACAGTTCTGGTCTAAA\n' +
          'CCGACTAATGAGAACTCACGGCTGATAAAATAGAGGGCAGTCGGAAAAAACGCTCGATCT\n' +
          'CCCCGGGTAAAGCGAGCGCTCGGTGGCTTGTATTCTATTCTGTCGAAGCGTGAGCGATAA\n' +
          'GCTCATCTAGGTACCTAACACTTTGTATAGAACGTTCGAGTTCATAGCACAACTTCCGCA\n' +
          'TGTATGACTTCGGCATCGGTCATTCGTCGATAACCGTGGCGCGTTTTCTGAGACGTTGTC\n' +
          'CCACGCGAGCTCCCTGTGAGGTCATGCAACCGATACGATGGTATCCTCAGTCTCATCGTT\n' +
          'AACTAATGATTAGGGACGCTGTGGTGTGCACACCAGCGCTCCAAGTACGGGCAAGTTTCC\n' +
          'CGTTCGGAGAGAACACGATCCGCCTAGGGATGTAATCCATGGGCAACTTGTTCCCCGCAC\n' +
          'CTAGGATTGTTGTCTCAACATCTGCCACTTCTAACGTTACCGGTGCATGCGGCAATTATA\n' +
          'ACCCCAGCTAGCCACTTCGTCGGAGAGGGGCGCCCGGTGCGGATTTTCCCATAAGTATAG\n' +
          'GTGGCCACGGTTATAATTATCCCGA\n' +
          '>Rosalind_2148\n' +
          'CGTGCCAGCGAAGGATAATTAGAACAGCAGAGGACTGCATAATCAGAGTAACGCGTAAAA\n' +
          'GTTGACCCATCGGCGCGAAAACTTACTGATTTGTATTCACATTTCGATCCCAGTGTGGGC\n' +
          'AAGTTCATTCCACTGTAGTCGTGTTTAGTAAGAACGCGCACTGTCTTTCTGGAGGCTTAG\n' +
          'AAATTTTTTGCAAACACACTGCACCCCGCTAACAGGTTCCGGGTAGCCTTGGCGCTTAGG\n' +
          'AGTTTTCGACCGACCTAACTCACTTGCCTCCTCTATTAGCGCGCAGGTTGCGTGAGATTA\n' +
          'TTGCGTTAACATGAGCATTCGCAGCGTGGCAGCAAGAATAGATGTAAACTTTGCAATAGA\n' +
          'TGATTCTATCCGCCACCCCACCGCTCGGCCCATCGGACTCCGTTGGCAGGACTCGTTGAG\n' +
          'CAGATTGGCAACTTAGCCTCGTCCATCTGTGTATAATGGACGACGTAACAACTGTCCCCT\n' +
          'ACTTCTTGTTGGCGCTACTGTTCAGATTTCCATCATACGGATGCGTCATGGTAGTAGCGT\n' +
          'TATGCAGAGTTTCTGGGTTCTAATGATTCCTAAACGTCCGCTTACACAGCGGAGCAGATG\n' +
          'GGATTACGACTTTGGAATAGCGGTGCGTTGATCTAGCTAAGCTCTTTCGCCACTCACAAA\n' +
          'AGCAAGGCTGTACTGTCGCTGTGACCTGATCGGTGCAACAACTTTCGCGTGTTCCCTCAT\n' +
          'GCATAAGGGTCTAAAAGGCCCTAGGTTCCGGTTCGGGTTCTGACTGAAGCCCCCGTGGCT\n' +
          'CTGGAAGAAAGCACTGGGACCGACAAATAACAATCCTTTTAACCGATGCAGATTCTAGTA\n' +
          'GAGCCGTAAGCCGCGATAATCGTAGGCGACTTGCGAAGCTCTGCATAGAGGAATGCTTTG\n' +
          'TGCATCGCCTCTTATCGATAAGTCC\n' +
          '>Rosalind_9214\n' +
          'AGCACCTGCCCATGTACGAGGCTAGCCCCCTGAGCTTTATTATGTCTAGCTCGCATTGCT\n' +
          'TTATAACGAGCACCATTGGATATGAATCATTGATTCTGGTCGAGGTCAAATGTGTGAAAG\n' +
          'AGCAAAAGTATCGGGCAGCGAAAGTTTTTGTCTAAATCACAAAAGGGTCGAATAGCAGGC\n' +
          'AGCTGATTACATTGTTACACTTTCGACGTAACCATGGTGATGGTGAGCACCGAACCCATT\n' +
          'CATAAGGTATACTGGTCGGGCCCGCGTCCATGCCGGCTGGTTCGATGCCTCATGGATCCT\n' +
          'GGTCATAAATAATACTACCATCACGCATCGATCCAACTAAGCTTCCAACTTGAACTGAAT\n' +
          'CTTAGACGACACGTTTAGCCAACCTATACCTTTTTAACGGCATGTTCAAGAAATCCCCTG\n' +
          'CTAGTACGTTGGTGTCTCACTACACACCCGGAGCATACGTAGTGCACTGACGTCACCGTC\n' +
          'GGAGTATCTTCTACCAGTAACGCAATTCTTAAGTACGGGGAATGCACAGGGCCTAGCCGA\n' +
          'CTATTAACGAGTCCGCGCGCAGATTCGATCTACGGCTGCTAGTACATATGCGACAGGAAG\n' +
          'GCATGTCGTCGTGTCCTTTAGATGGGAGCGCAAGGCTTAAACTACTCCAGTACGTATTCC\n' +
          'GAGAGCTCTACATAGGCACATCCACGGCCTTCGCTAAATAGAAGATCGGGCTGGCGCAGG\n' +
          'GACCTCAATGGTTGAGGGCGTGGGACCTGTTGTCACCATCTACTATCGTTGTCTTCAATT\n' +
          'AACACCAATGGGTCTAAACGCTGTTTCTAATATTCTCGTCTGTTGCGTGTCACACGATAG\n' +
          'GGTTCGCCCGGAAGTTGTTAACCCAAGTCAATAGCATTCGGAACTACGAACGACTTGGGT\n' +
          'ATGACATGATATAGCATGACCCAGG\n' +
          '>Rosalind_4225\n' +
          'CAGTCGTCGCTAAGTGTAATTTCCGTGCTCGGGCCCCGGTCATACGAGCACCCCGTTCGT\n' +
          'AGGGTAACCTTAGAATGTCACGTCGGTCACGCTCAAAATCAGGTCCAGACTAGGAGGGAA\n' +
          'CTGCTCGAAAGTAGGTCACTCCCCAGTCGTTCATAACGCGCACTCTATCAGATGCAATTC\n' +
          'GAAAGGGGTCTGAAAAAAATTTTCATATTTCCAAACTCATTATTCGTACTGACGAGCTGA\n' +
          'AAACATCTGGTTGTTGTGACGATGGTGTTAGTGGTATTCGGAACCAGGGGCGATCTGGGC\n' +
          'TTGACGAAAGTTCTTCTCTCCCATCGAGACAGTTGTACAACTGGGTACAAGTCGTACATG\n' +
          'CTAGAGAATTGATATCTTAGGACAATTAGCTACGCCCTGCATACACGCACTCCACTACAT\n' +
          'TGTAACAATGACGGAACACTATATACCTAATCTCACTTTACGACTCAGATACAGTTCGAT\n' +
          'AGCTTCCCACGGATGTTCACTTAGTTAGCCATCAGCTGAGGATGTACGGCCAAAATGCCA\n' +
          'AGGAACAGCAGCACGGGTTTGTCTCCGTCCTGCTTAAGCAACATCGCAAATAGATCGCCC\n' +
          'CTTATAGCCACCAACTACTACCTGAATTCGGGACTATAAGCGGATATGTATTCGGCGGCC\n' +
          'CGCGGATGCTCTGCTGCATTCCGTAGGACGAAGCTTCTCAACGACGCGGCTTTATTTACC\n' +
          'TATCAATACCCTCCGAGCCAACAAGGTTGTACACGCGAAGTGGAATCAAGACAGCGGGTT\n' +
          'GCCTATCTCGCGCATAGCCAACGTAATGCCAAACGGTCGACCCACTAAGATCCCTGCATA\n' +
          'GGAAAACCGCCTCTTCTAGGGTCTAGAGATCGATTGCTCACTTGGTTCGGCATCTCTGGG\n' +
          'AGACATCCATTGTTAAACATGATAT',
      consensus: 'CAGTCCTGCCTAGGTTAAATGAACGCACAGGCAAAGGAATCATTAGGATCCCGCACAGCTTCCTCAACACGGCCAGCGCACACGATTTAGGGGGAATGACCGGTATAGTCTTAGACATACATCCTAGACACAGAGTAACGCTAGAGTCTATGAAAGCGTACATCCTATCAAAACGCATACAAACGCGTACAGAAAAACTCTTACAACCTGACCAAATCACTAGGAGGCAACACGAAAAGAAATCTGCACGCGAGCGTGGCAACCATGCTACGCGAACTCTTAGGATGGCGCAATCAAGGAGGGCTAAAACAACACCATTCGCACCCAGACAGCCAGTATAGCCACCACCAGTACCAGAAACTGATTAATCCGCCTCGCCCGACCAAGAACTAAGGCCCAGTGAGAACAACACCTCCACAGCAAAACGTAAAAGGACCCATCTCAAGCTTGAAGTAACTACTGTCGAAGCTAGAGAGCCCCAGCTATCCACGGACCTACAACTCAGTAGCCAACAAACGGGAGCGAACAGGGAATTAACCAAGAATAAAGACCCCGGGATTAAATCCGCCCTAAGTCTGCAATTACACATGCAAAACGGTGCTAACCACGCTCCCCCATACGATGGAGTTGCACTAACCAGGGGACTTAAGTACGACCGTCAACAAATGGACAGGTACACAAGGACGGGAAAAACTAAACAACAGCGCCGGCTGACGTCACGAACAGAACAGTACAAGACATGACGACCCTTCTCACGAACTACAATCATGGCCACCGAATGTCGATCATTGGGATAAACAAAGTAAATACCAATCGTTTAAGGGTCGTGTCCAACGAGTAGGACCAGCCCGATCTCTAGTCCGAAACGATATCCAAATCAGGAGTTTCAACAAGTCGGGGAGGGAAGCCGCGTCAAAAATCATAA',
      profile: [
          [ 2, 3, 0, 2, 2, 1, 2, 1, 1, 3, 1, 4, 2, 2, 2, 2, 4, 4, 4, 3, 3, 3, 3, 3, 1, 2, 3, 1, 4, 1, 2, 2, 5, 3, 4, 2, 1, 3, 7, 3, 2, 4, 1, 2, 3, 1, 2, 4, 3, 3, 3, 1, 0, 3, 6, 2, 4, 1, 2, 2, 1, 2, 2, 3, 2, 4, 3, 1, 3, 1, 2, 2, 0, 3, 3, 0, 2, 1, 3, 4, 1, 5, 2, 2, 4, 3, 2, 2, 4, 2, 1, 3, 3, 0, 3, 3, 2, 3, 4, 2, 3, 3, 1, 1, 4, 2, 4, 1, 3, 2, 2, 2, 3, 2, 3, 1, 4, 3, 5, 3, 3, 3, 2, 2, 2, 5, 3, 4, 2, 3, 2, 5, 3, 3, 1, 1, 4, 3, 2, 1, 2, 2, 3, 0, 4, 1, 4, 1, 1, 3, 2, 2, 5, 3, 4, 2, 0, 1, 1, 3, 3, 4, 2, 2, 0, 3, 5, 1, 0, 4, 4, 4, 3, 3, 3, 2, 3, 1, 3, 0, 4, 4, 4, 2, 2, 2, 1, 2, 3, 3, 3, 1, 5, 4, 4, 5, 4, 3, 3, 1, 3, 2, 4, 1, 5, 5, 2, 2, 1, 2, 3, 2, 3, 5, 3, 4, 1, 1, 5, 3, 1, 4, 3, 1, 4, 3, 2, 1, 3, 3, 3, 4, 2, 3, 4, 4, 3, 4, 3, 4, 4, 4, 3, 1, 3, 2, 2, 4, 2, 2, 2, 3, 4, 0, 2, 1, 2, 3, 4, 0, 3, 6, 2, 1, 4, 2, 1, 1, 2, 4, 2, 1, 2, 0, 4, 4, 0, 4, 0, 1, 0, 4, 3, 1, 5, 1, 1, 0, 2, 3, 1, 3, 5, 3, 2, 4, 3, 3, 1, 4, 1, 0, 2, 3, 1, 5, 3, 6, 5, 1, 3, 3, 1, 4, 2, 1, 4, 3, 2, 3, 1, 1, 4, 2, 0, 0, 4, 0, 3, 2, 5, 0, 0, 2, 3, 2, 3, 4, 3, 4, 0, 3, 1, 5, 2, 2, 7, 3, 2, 5, 1, 2, 4, 2, 2, 4, 1, 6, 4, 5, 2, 2, 3, 3, 2, 2, 5, 7, 3, 2, 3, 3, 2, 2, 2, 2, 2, 1, 1, 2, 2, 6, 2, 2, 3, 4, 2, 5, 3, 3, 2, 6, 3, 3, 1, 1, 2, 1, 3, 1, 2, 1, 5, 1, 5, 4, 3, 6, 4, 3, 4, 2, 1, 3, 3, 1, 5, 3, 4, 0, 2, 3, 5, 4, 4, 2, 3, 3, 4, 4, 3, 4, 1, 2, 7, 1, 1, 1, 4, 1, 2, 3, 2, 4, 5, 3, 2, 1, 2, 3, 3, 4, 1, 1, 6, 4, 2, 2, 3, 3, 3, 3, 2, 3, 0, 6, 3, 3, 2, 3, 4, 0, 3, 2, 3, 1, 3, 2, 2, 2, 3, 3, 2, 1, 3, 2, 1, 1, 5, 1, 2, 2, 4, 1, 0, 3, 6, 2, 4, 3, 2, 1, 3, 3, 2, 1, 4, 1, 1, 2, 4, 5, 1, 3, 4, 3, 2, 0, 3, 2, 3, 2, 2, 3, 3, 4, 1, 4, 2, 2, 2, 5, 5, 3, 2, 5, 3, 1, 1, 4, 3, 3, 3, 4, 3, 4, 4, 4, 1, 4, 0, 2, 2, 0, 2, 0, 1, 3, 1, 0, 4, 4, 4, 2, 0, 2, 1, 2, 3, 2, 0, 4, 6, 2, 2, 2, 3, 2, 0, 4, 5, 0, 3, 4, 2, 4, 2, 4, 2, 2, 3, 4, 6, 4, 3, 1, 2, 3, 2, 1, 3, 0, 4, 4, 2, 3, 3, 1, 1, 1, 2, 0, 1, 2, 3, 1, 4, 2, 4, 2, 2, 3, 3, 1, 2, 3, 1, 2, 3, 2, 3, 3, 3, 0, 4, 4, 1, 2, 4, 3, 2, 1, 1, 3, 1, 3, 1, 4, 4, 2, 1, 4, 2, 0, 3, 2, 2, 1, 2, 3, 3, 4, 1, 5, 4, 4, 2, 1, 2, 4, 1, 4, 0, 2, 2, 3, 2, 3, 3, 4, 4, 1, 0, 3, 1, 2, 1, 2, 5, 3, 3, 4, 3, 1, 1, 3, 5, 5, 0, 5, 5, 2, 4, 3, 3, 2, 2, 2, 0, 0, 2, 1, 2, 4, 2, 1, 2, 3, 4, 2, 0, 4, 3, 1, 5, 3, 5, 6, 0, 3, 1, 2, 4, 2, 3, 3, 2, 5, 2, 3, 2, 1, 4, 2, 2, 4, 1, 1, 0, 1, 2, 1, 2, 2, 5, 1, 1, 6, 3, 1, 1, 4, 2, 4, 5, 2, 1, 5, 2, 2, 2, 0, 1, 3, 1, 3, 2, 5, 4, 1, 1, 2, 2, 2, 3, 3, 3, 5, 2, 1, 2, 1, 2, 3, 2, 3, 4, 3, 1, 5, 5, 3, 3, 2, 3, 4, 4, 1, 5, 2, 2, 4, 3, 2, 1, 1, 0, 1, 1, 4, 3, 1, 2, 2, 1, 2, 3, 2, 2, 2, 2, 2, 3, 5, 2, 1, 5, 3, 2, 4, 2, 3, 4, 2, 1, 3, 2, 3, 2, 1, 1, 4, 2, 3, 1, 2, 0, 4, 3, 3, 2, 2, 1, 3, 6, 5, 1, 1, 6, 3, 4, 2, 2, 2, 3, 5, 3, 1, 1, 4, 0, 3, 4, 1, 3, 4, 3, 1, 4, 5, 3, 3, 4, 2, 1, 2, 3, 2, 1, 1, 3, 0, 4, 2, 3, 4, 2, 1, 2, 0, 2, 1, 3, 2, 3, 5, 4, 6, 5, 1, 1, 4, 1, 3, 4 ],
          [ 4, 1, 2, 1, 3, 5, 3, 2, 3, 4, 2, 2, 2, 2, 1, 1, 2, 2, 4, 1, 1, 2, 2, 4, 2, 3, 2, 4, 2, 3, 3, 4, 2, 3, 4, 2, 3, 2, 0, 1, 3, 1, 1, 2, 3, 2, 3, 1, 2, 4, 4, 4, 4, 6, 1, 4, 2, 3, 4, 1, 3, 4, 3, 1, 3, 1, 2, 5, 3, 3, 2, 2, 4, 4, 2, 2, 4, 3, 4, 1, 5, 2, 4, 2, 3, 2, 3, 2, 2, 2, 1, 2, 2, 2, 1, 3, 3, 2, 1, 4, 4, 1, 2, 3, 2, 2, 3, 2, 3, 5, 2, 2, 1, 1, 3, 4, 1, 0, 2, 4, 1, 1, 3, 5, 3, 2, 0, 1, 3, 3, 3, 1, 2, 2, 1, 2, 4, 1, 4, 2, 5, 3, 2, 2, 2, 1, 0, 3, 1, 3, 2, 3, 0, 1, 3, 1, 5, 1, 3, 3, 4, 2, 1, 4, 5, 1, 3, 1, 5, 1, 2, 3, 3, 5, 2, 5, 3, 1, 2, 4, 3, 2, 4, 4, 1, 4, 1, 1, 3, 4, 3, 3, 2, 2, 2, 0, 4, 4, 2, 4, 1, 3, 2, 6, 2, 2, 3, 3, 2, 2, 2, 4, 4, 3, 2, 3, 2, 4, 3, 4, 1, 2, 1, 0, 2, 2, 2, 6, 3, 3, 4, 1, 5, 1, 2, 1, 3, 1, 0, 1, 4, 1, 0, 6, 2, 1, 5, 2, 4, 2, 4, 2, 2, 2, 4, 2, 3, 1, 1, 4, 2, 1, 6, 4, 1, 1, 2, 3, 2, 4, 4, 3, 3, 2, 1, 1, 4, 0, 4, 2, 0, 1, 3, 3, 2, 1, 2, 2, 3, 0, 6, 3, 3, 0, 4, 1, 3, 2, 3, 3, 2, 1, 1, 4, 2, 0, 2, 1, 2, 3, 3, 3, 5, 2, 4, 5, 0, 2, 1, 5, 3, 5, 3, 6, 6, 4, 0, 2, 3, 4, 2, 3, 7, 5, 2, 2, 2, 1, 2, 2, 4, 4, 4, 2, 4, 4, 1, 4, 4, 0, 2, 1, 1, 4, 3, 2, 1, 0, 1, 2, 6, 2, 1, 1, 2, 3, 1, 2, 2, 4, 4, 2, 3, 3, 2, 4, 2, 3, 4, 5, 2, 3, 3, 3, 2, 4, 1, 1, 3, 5, 2, 0, 3, 2, 3, 4, 5, 5, 2, 4, 3, 2, 1, 2, 2, 2, 6, 1, 2, 4, 2, 3, 5, 2, 4, 5, 1, 4, 1, 3, 5, 2, 2, 2, 2, 3, 2, 0, 2, 2, 2, 2, 3, 2, 2, 5, 6, 6, 2, 3, 5, 2, 4, 2, 2, 2, 5, 3, 2, 0, 2, 3, 1, 3, 2, 2, 4, 1, 2, 4, 3, 1, 2, 5, 4, 2, 3, 0, 5, 0, 4, 3, 3, 3, 3, 3, 4, 3, 3, 3, 3, 2, 3, 2, 3, 2, 5, 5, 1, 4, 1, 0, 4, 4, 6, 0, 1, 5, 3, 3, 3, 1, 4, 3, 2, 1, 0, 2, 5, 3, 2, 1, 6, 1, 2, 2, 4, 4, 1, 1, 3, 2, 3, 1, 2, 2, 4, 2, 1, 3, 2, 2, 2, 0, 1, 2, 3, 5, 5, 2, 2, 2, 2, 1, 1, 1, 2, 3, 2, 1, 4, 3, 4, 6, 1, 3, 2, 3, 2, 3, 2, 1, 2, 2, 4, 3, 2, 3, 4, 6, 1, 0, 2, 2, 3, 4, 2, 1, 5, 1, 2, 2, 0, 1, 4, 0, 4, 3, 1, 3, 4, 2, 1, 2, 1, 5, 0, 2, 2, 3, 4, 4, 1, 2, 3, 4, 3, 3, 3, 5, 1, 4, 4, 5, 4, 5, 2, 3, 1, 3, 2, 3, 1, 2, 2, 2, 2, 1, 3, 2, 4, 1, 5, 1, 3, 3, 4, 3, 2, 0, 2, 3, 2, 1, 3, 3, 3, 3, 1, 2, 2, 1, 3, 2, 2, 3, 5, 0, 2, 5, 2, 2, 5, 2, 1, 4, 2, 3, 2, 0, 4, 1, 2, 1, 1, 2, 5, 2, 4, 1, 2, 2, 3, 2, 7, 2, 1, 3, 4, 1, 3, 2, 3, 3, 2, 3, 2, 1, 5, 0, 4, 4, 3, 1, 4, 2, 4, 4, 3, 2, 3, 2, 2, 4, 3, 1, 2, 4, 4, 4, 2, 3, 3, 5, 1, 2, 1, 1, 4, 3, 3, 1, 2, 5, 3, 3, 1, 1, 5, 3, 2, 3, 1, 3, 0, 2, 3, 5, 5, 2, 3, 4, 1, 3, 2, 4, 3, 2, 1, 5, 2, 3, 4, 4, 2, 3, 4, 1, 3, 2, 2, 4, 5, 3, 6, 4, 1, 2, 1, 1, 3, 1, 4, 3, 2, 1, 4, 0, 1, 2, 1, 4, 2, 3, 1, 3, 3, 3, 5, 1, 3, 3, 1, 3, 2, 3, 3, 1, 2, 6, 5, 2, 2, 3, 5, 2, 3, 2, 3, 4, 2, 2, 3, 2, 2, 3, 1, 1, 2, 1, 4, 5, 3, 1, 3, 1, 2, 1, 1, 2, 2, 2, 1, 5, 6, 2, 2, 4, 5, 4, 2, 3, 2, 4, 1, 3, 2, 3, 1, 1, 4, 3, 2, 2, 1, 1, 4, 0, 2, 1, 3, 1, 3, 3, 3, 1, 3, 3, 5, 2, 3, 1, 1, 3, 0, 0, 1, 6, 3, 2, 4, 2, 1, 2, 1, 4, 1, 1, 0, 2, 2, 3, 1, 2, 3, 4, 2, 4, 3, 1, 3, 2, 1, 3, 2, 2, 1, 1, 2, 1, 4, 2, 1, 3, 4 ],
          [ 3, 3, 4, 2, 3, 3, 1, 5, 3, 2, 1, 2, 4, 3, 3, 1, 2, 4, 1, 2, 4, 2, 3, 2, 5, 2, 3, 4, 1, 5, 4, 4, 2, 3, 1, 3, 4, 3, 2, 0, 2, 2, 3, 2, 1, 4, 4, 2, 1, 1, 1, 2, 5, 1, 3, 1, 1, 4, 2, 3, 1, 1, 3, 2, 2, 3, 3, 3, 2, 3, 3, 4, 2, 2, 3, 5, 2, 5, 2, 4, 0, 1, 0, 3, 2, 1, 1, 2, 1, 3, 4, 4, 4, 5, 3, 1, 1, 4, 3, 1, 2, 4, 4, 1, 3, 1, 1, 4, 0, 1, 2, 2, 3, 4, 2, 4, 2, 2, 3, 3, 3, 2, 2, 1, 1, 2, 4, 3, 2, 1, 2, 1, 4, 3, 5, 1, 0, 3, 2, 4, 2, 1, 3, 4, 0, 4, 1, 3, 2, 2, 2, 4, 1, 3, 1, 6, 2, 7, 2, 2, 3, 1, 3, 2, 2, 1, 1, 2, 4, 1, 3, 2, 1, 2, 4, 3, 2, 2, 3, 2, 3, 2, 1, 0, 4, 2, 4, 3, 2, 2, 3, 4, 2, 3, 2, 2, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 3, 3, 2, 3, 3, 3, 1, 0, 2, 2, 3, 1, 2, 2, 3, 3, 5, 5, 2, 4, 3, 1, 3, 1, 3, 4, 1, 4, 1, 3, 1, 2, 4, 3, 0, 3, 3, 2, 1, 4, 2, 2, 2, 4, 1, 4, 2, 4, 2, 4, 0, 5, 5, 4, 3, 1, 1, 3, 1, 3, 4, 3, 2, 1, 2, 4, 2, 5, 3, 2, 4, 1, 3, 3, 4, 3, 4, 4, 2, 3, 6, 5, 3, 4, 3, 2, 0, 3, 2, 2, 3, 4, 4, 1, 4, 7, 4, 1, 3, 1, 2, 0, 3, 3, 1, 1, 2, 2, 2, 1, 3, 1, 3, 2, 4, 3, 3, 1, 2, 4, 2, 5, 3, 2, 2, 4, 2, 0, 3, 3, 1, 2, 1, 3, 5, 1, 2, 2, 2, 1, 0, 2, 2, 2, 5, 3, 3, 4, 2, 2, 5, 2, 2, 1, 0, 2, 4, 3, 2, 1, 1, 1, 1, 2, 3, 4, 2, 3, 1, 1, 3, 3, 1, 2, 5, 1, 2, 3, 3, 0, 4, 3, 2, 1, 2, 3, 1, 4, 4, 3, 1, 2, 3, 5, 1, 5, 1, 4, 2, 3, 1, 2, 2, 2, 2, 3, 2, 1, 3, 1, 2, 2, 2, 4, 0, 2, 2, 3, 2, 3, 4, 3, 2, 1, 3, 3, 4, 4, 0, 3, 2, 1, 3, 2, 1, 1, 1, 1, 1, 4, 0, 2, 2, 4, 2, 1, 6, 2, 1, 1, 2, 3, 2, 0, 0, 6, 1, 2, 5, 0, 1, 5, 1, 3, 1, 7, 1, 4, 2, 4, 0, 2, 3, 3, 2, 4, 2, 3, 1, 0, 2, 2, 1, 1, 5, 6, 0, 3, 2, 1, 1, 1, 0, 3, 2, 3, 0, 1, 4, 3, 2, 4, 1, 3, 3, 0, 2, 3, 1, 2, 3, 6, 4, 6, 2, 3, 2, 5, 3, 0, 4, 3, 4, 4, 3, 0, 1, 3, 2, 1, 2, 2, 3, 3, 2, 4, 3, 2, 2, 2, 2, 2, 4, 2, 2, 3, 2, 1, 4, 5, 5, 2, 3, 3, 2, 3, 1, 2, 2, 3, 5, 2, 2, 0, 2, 2, 1, 4, 1, 3, 1, 4, 3, 2, 2, 3, 2, 2, 3, 4, 1, 1, 2, 4, 2, 4, 2, 3, 3, 2, 5, 4, 2, 5, 3, 1, 1, 2, 2, 0, 3, 3, 4, 1, 3, 2, 2, 1, 1, 3, 1, 1, 1, 3, 5, 1, 2, 4, 3, 2, 4, 1, 0, 4, 3, 3, 0, 3, 2, 2, 1, 3, 2, 5, 4, 5, 4, 3, 3, 0, 1, 3, 2, 3, 1, 1, 2, 4, 3, 2, 2, 6, 1, 1, 2, 2, 4, 2, 3, 2, 2, 4, 3, 2, 1, 3, 4, 4, 3, 3, 0, 2, 1, 1, 3, 4, 5, 3, 0, 5, 4, 4, 0, 3, 1, 3, 3, 3, 3, 2, 0, 2, 4, 2, 1, 2, 1, 5, 2, 4, 3, 4, 6, 5, 2, 1, 3, 2, 2, 5, 2, 2, 1, 2, 4, 2, 1, 0, 2, 4, 3, 3, 2, 1, 4, 2, 2, 1, 3, 3, 4, 4, 0, 2, 2, 4, 4, 2, 4, 2, 3, 2, 3, 3, 1, 2, 3, 2, 2, 4, 4, 1, 3, 2, 3, 3, 3, 0, 2, 1, 3, 2, 1, 3, 3, 2, 2, 1, 2, 1, 4, 2, 2, 2, 4, 2, 4, 4, 3, 2, 1, 2, 3, 2, 5, 5, 3, 2, 2, 3, 3, 2, 1, 3, 1, 2, 4, 1, 3, 0, 2, 3, 1, 0, 0, 1, 2, 1, 4, 5, 3, 2, 1, 1, 2, 6, 4, 3, 3, 2, 5, 2, 6, 2, 3, 2, 1, 3, 3, 4, 1, 5, 1, 3, 4, 4, 3, 1, 1, 3, 4, 2, 2, 4, 4, 1, 1, 2, 2, 3, 3, 1, 4, 1, 3, 3, 5, 3, 2, 4, 4, 7, 2, 2, 2, 3, 2, 2, 3, 2, 3, 1, 3, 3, 5, 4, 3, 5, 3, 1, 2, 2, 1, 3, 1, 3, 2, 4, 2, 1, 4, 4, 5, 6, 2, 4, 5, 4, 1, 1, 4, 3, 3, 5, 2, 4, 1, 2, 2, 1, 3, 1, 1, 3, 3, 2, 1, 3, 1 ],
          [ 1, 3, 4, 5, 2, 1, 4, 2, 3, 1, 6, 2, 2, 3, 4, 6, 2, 0, 1, 4, 2, 3, 2, 1, 2, 3, 2, 1, 3, 1, 1, 0, 1, 1, 1, 3, 2, 2, 1, 6, 3, 3, 5, 4, 3, 3, 1, 3, 4, 2, 2, 3, 1, 0, 0, 3, 3, 2, 2, 4, 5, 3, 2, 4, 3, 2, 2, 1, 2, 3, 3, 2, 4, 1, 2, 3, 2, 1, 1, 1, 4, 2, 4, 3, 1, 4, 4, 4, 3, 3, 4, 1, 1, 3, 3, 3, 4, 1, 2, 3, 1, 2, 3, 5, 1, 5, 2, 3, 4, 2, 4, 4, 3, 3, 2, 1, 3, 5, 0, 0, 3, 4, 3, 2, 4, 1, 3, 2, 3, 3, 3, 3, 1, 2, 3, 6, 2, 3, 2, 3, 1, 4, 2, 4, 4, 4, 5, 3, 6, 2, 4, 1, 4, 3, 2, 1, 3, 1, 4, 2, 0, 3, 4, 2, 3, 5, 1, 6, 1, 4, 1, 1, 3, 0, 1, 0, 2, 6, 2, 4, 0, 2, 1, 4, 3, 2, 4, 4, 2, 1, 1, 2, 1, 1, 2, 3, 1, 2, 4, 4, 5, 4, 4, 2, 1, 2, 2, 2, 5, 3, 2, 1, 2, 2, 3, 1, 4, 4, 0, 1, 5, 1, 1, 4, 2, 1, 3, 2, 1, 3, 0, 1, 2, 2, 3, 2, 3, 3, 3, 2, 2, 2, 4, 1, 4, 3, 1, 2, 2, 2, 3, 1, 2, 4, 2, 3, 5, 1, 0, 2, 2, 2, 1, 2, 4, 4, 3, 3, 4, 1, 2, 2, 3, 3, 2, 3, 2, 5, 3, 4, 6, 2, 0, 2, 1, 5, 1, 3, 2, 3, 0, 2, 2, 4, 2, 3, 1, 1, 2, 2, 3, 2, 3, 2, 4, 4, 3, 3, 0, 3, 3, 3, 2, 2, 2, 3, 3, 4, 4, 0, 2, 1, 0, 1, 2, 2, 4, 3, 1, 2, 1, 3, 1, 3, 2, 3, 4, 3, 4, 1, 1, 2, 3, 1, 2, 3, 2, 1, 2, 3, 2, 4, 2, 0, 3, 2, 3, 2, 3, 2, 2, 4, 2, 3, 4, 4, 3, 0, 4, 2, 0, 1, 3, 2, 5, 3, 3, 3, 4, 1, 1, 0, 3, 2, 2, 2, 3, 1, 2, 1, 4, 1, 3, 1, 2, 2, 2, 2, 2, 0, 4, 2, 3, 3, 1, 1, 0, 1, 2, 1, 2, 2, 2, 4, 0, 3, 2, 1, 3, 3, 3, 3, 1, 1, 2, 2, 1, 4, 2, 3, 2, 1, 2, 2, 1, 1, 1, 2, 1, 4, 2, 4, 3, 3, 2, 1, 3, 4, 4, 3, 3, 2, 2, 4, 1, 3, 2, 4, 3, 3, 4, 0, 5, 0, 1, 2, 3, 2, 2, 4, 1, 0, 3, 1, 2, 2, 3, 3, 2, 2, 2, 1, 3, 4, 3, 6, 2, 2, 3, 4, 2, 2, 2, 2, 2, 6, 2, 2, 3, 1, 3, 5, 3, 3, 2, 5, 4, 3, 3, 2, 1, 4, 1, 3, 3, 3, 1, 0, 2, 1, 2, 3, 3, 1, 2, 4, 1, 1, 3, 1, 3, 3, 2, 4, 5, 2, 2, 2, 1, 1, 3, 1, 2, 3, 4, 3, 2, 1, 3, 3, 4, 2, 2, 3, 3, 2, 2, 2, 4, 4, 2, 2, 3, 4, 4, 2, 2, 3, 1, 2, 7, 4, 1, 2, 4, 1, 4, 3, 2, 3, 1, 5, 5, 3, 1, 2, 3, 2, 5, 1, 1, 0, 1, 1, 3, 2, 3, 1, 4, 1, 0, 5, 4, 2, 3, 3, 1, 3, 2, 3, 4, 4, 3, 2, 2, 1, 3, 4, 4, 2, 1, 3, 4, 3, 3, 3, 3, 6, 4, 2, 0, 3, 2, 6, 1, 1, 4, 2, 2, 2, 2, 1, 3, 3, 3, 4, 5, 0, 3, 3, 6, 4, 3, 4, 2, 3, 1, 3, 5, 1, 3, 2, 0, 1, 2, 0, 4, 2, 3, 4, 4, 2, 4, 3, 4, 2, 3, 3, 2, 4, 1, 3, 2, 2, 2, 1, 4, 1, 1, 3, 3, 1, 1, 3, 4, 2, 3, 2, 1, 3, 0, 2, 2, 1, 1, 2, 1, 0, 1, 3, 3, 6, 3, 0, 3, 3, 4, 1, 1, 2, 4, 1, 3, 4, 2, 1, 1, 0, 4, 3, 2, 5, 2, 2, 1, 1, 3, 0, 3, 2, 4, 2, 1, 3, 4, 2, 3, 2, 2, 4, 4, 3, 4, 3, 1, 1, 2, 1, 3, 2, 4, 0, 1, 2, 1, 4, 2, 2, 4, 3, 3, 4, 2, 3, 1, 2, 3, 1, 3, 6, 2, 5, 0, 1, 2, 4, 2, 3, 4, 5, 2, 0, 3, 2, 5, 1, 0, 2, 3, 1, 1, 2, 2, 4, 2, 3, 1, 5, 2, 2, 3, 3, 3, 4, 0, 2, 4, 5, 5, 1, 3, 1, 1, 3, 4, 3, 1, 5, 0, 5, 1, 1, 3, 1, 2, 4, 2, 1, 6, 1, 2, 1, 2, 2, 2, 2, 2, 1, 1, 1, 3, 2, 5, 1, 6, 2, 5, 2, 2, 5, 1, 2, 2, 2, 1, 0, 1, 2, 0, 4, 1, 4, 3, 3, 1, 2, 1, 5, 1, 1, 2, 2, 2, 1, 4, 5, 4, 1, 2, 0, 2, 2, 3, 2, 6, 3, 2, 3, 4, 1, 3, 3, 0, 2, 3, 1, 2, 2, 2, 4, 3, 3, 5, 3, 3, 2, 2, 2, 2, 5, 2, 2, 7, 1, 1 ]
      ] as int[][]
  ]
}
